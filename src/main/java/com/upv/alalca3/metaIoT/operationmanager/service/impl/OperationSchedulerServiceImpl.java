/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.service.impl;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import com.upv.alalca3.metaIoT.operationmanager.components.OperationMapper;
import com.upv.alalca3.metaIoT.operationmanager.factories.CronExpressionFactory;
import com.upv.alalca3.metaIoT.operationmanager.model.Operation;
import com.upv.alalca3.metaIoT.operationmanager.model.OperationSchedule;
import com.upv.alalca3.metaIoT.operationmanager.model.OperationSchedulingData;
import com.upv.alalca3.metaIoT.operationmanager.repositories.jpa.OperationRepository;
import com.upv.alalca3.metaIoT.operationmanager.service.MqttService;
import com.upv.alalca3.metaIoT.operationmanager.service.OperationSchedulerService;
import com.upv.alalca3.metaIoT.operationmanager.utils.enums.Frequency;

import jakarta.annotation.PostConstruct;

/**
 * 
 */
@Service
public class OperationSchedulerServiceImpl implements OperationSchedulerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OperationSchedulerServiceImpl.class);

    private final TaskScheduler taskScheduler;
    private final Map<Long, ScheduledFuture<?>> scheduledTasks = new HashMap<>();

    private final OperationRepository repository;
    private final OperationMapper mapper;

    private final MqttService mqttService;

    /**
     * Default constructor
     * 
     * @param taskScheduler component in charge of launching the operations at the
     *                      scheduled time
     * @param repository    repository to get the operations information
     * @param mapper        mapper component for mapping operations
     * @param mqttService   service for publishing operations
     */
    public OperationSchedulerServiceImpl(TaskScheduler taskScheduler, OperationRepository repository,
	    OperationMapper mapper, MqttService mqttService) {
	super();
	this.taskScheduler = taskScheduler;
	this.repository = repository;
	this.mapper = mapper;
	this.mqttService = mqttService;
    }

    @PostConstruct
    protected void init() {
	// Search all scheduled operations and create the scheduling
	List<? extends Operation> list = this.repository.findScheduledOperations();
	list.forEach(op -> this.scheduleOperationTask(op.getSchedule()));
    }

    @Override
    public <E extends Operation> E scheduleOperation(E operation) {
	OperationSchedulingData schedulingData = operation.getSchedulingData();
	Frequency frequency = schedulingData.getFrequency();
	Instant scheduledDate = schedulingData.getScheduledDate();
	OperationSchedule schedule = new OperationSchedule(operation,
		CronExpressionFactory.fromInstantAndFrequency(scheduledDate, frequency));
	operation.setSchedule(schedule);
	schedule.setId(operation.getId());
	operation = this.repository.save(operation);
	this.scheduleOperationTask(operation.getSchedule());
	return operation;
    }

    private void scheduleOperationTask(OperationSchedule schedule) {
	Runnable task = () -> {
	    LOGGER.info("Launching operation ...");
	    this.publishOperation(schedule.getOperation());
	    this.handleIterations(schedule);
	    LOGGER.info("Operation launched");
	};
	CronTrigger cronTrigger = new CronTrigger(schedule.getCronExpression());
	ScheduledFuture<?> scheduledTask = this.taskScheduler.schedule(task, cronTrigger);
	this.scheduledTasks.put(schedule.getId(), scheduledTask);
    }

    private <E extends Operation> void publishOperation(E operation) {
	this.mqttService.publishOperation(this.mapper.toDto(operation));
    }

    private void handleIterations(OperationSchedule schedule) {
	Operation operation = schedule.getOperation();
	OperationSchedulingData schedulingData = operation.getSchedulingData();
	if (schedulingData.getMaxIterations() != null) {
	    schedule.setIterations(schedule.getIterations() + 1);
	    if (schedule.getIterations().compareTo(schedulingData.getMaxIterations()) >= 0) {
		this.cancelOperationSchedule(operation);
	    }
	}
    }

    private void cancelScheduledTask(Long scheduleId) {
	ScheduledFuture<?> scheduledTask = this.scheduledTasks.get(scheduleId);
	if (scheduledTask != null) {
	    scheduledTask.cancel(true);
	    this.scheduledTasks.remove(scheduleId);
	}
    }

    private <E extends Operation> void deleteOperationSchedule(E operation) {
	operation.setSchedule(null);
	this.repository.save(operation);
    }

    @Override
    public <E extends Operation> void cancelOperationSchedule(E operation) {
	OperationSchedule schedule = operation.getSchedule();
	if (schedule != null && schedule.getId() != null) {
	    this.cancelScheduledTask(schedule.getId());
	    this.deleteOperationSchedule(operation);
	}
    }
}
