/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upv.alalca3.metaIoT.operationmanager.components.OperationMapper;
import com.upv.alalca3.metaIoT.operationmanager.model.Operation;
import com.upv.alalca3.metaIoT.operationmanager.model.dto.OperationDTO;
import com.upv.alalca3.metaIoT.operationmanager.repositories.jpa.OperationRepository;
import com.upv.alalca3.metaIoT.operationmanager.service.MqttService;
import com.upv.alalca3.metaIoT.operationmanager.service.OperationSchedulerService;
import com.upv.alalca3.metaIoT.operationmanager.service.OperationService;

/**
 * Implementation of {@link OperationService}
 */
@Service
public class OperationServiceImpl implements OperationService {
    private final OperationRepository repository;
    private final OperationMapper mapper;
    private final MqttService mqttService;
    private final OperationSchedulerService scheduler;

    /**
     * Default constructor
     * 
     * @param repository
     * @param mapper
     * @param mqttService
     * @param scheduler
     */
    @Autowired
    public OperationServiceImpl(OperationRepository repository, OperationMapper mapper, MqttService mqttService,
	    OperationSchedulerService scheduler) {
	super();
	this.repository = repository;
	this.mapper = mapper;
	this.mqttService = mqttService;
	this.scheduler = scheduler;
    }

    @Override
    public <E extends Operation, D extends OperationDTO> D save(D dto) {
	E newEntity = this.mapper.toEntity(dto);
	D savedDTO;
	if (newEntity.getSchedulingData() != null) {
	    savedDTO = this.mapper.toDto(this.scheduler.scheduleOperation(newEntity));

	} else {
	    savedDTO = this.mapper.toDto(this.repository.save(newEntity));
	    this.mqttService.publishOperation(savedDTO);
	}
	return savedDTO;
    }

    @Override
    public <D extends OperationDTO> Optional<D> get(Long id) {
	return this.repository.findById(id).map(this.mapper::toDto);
    }
}
