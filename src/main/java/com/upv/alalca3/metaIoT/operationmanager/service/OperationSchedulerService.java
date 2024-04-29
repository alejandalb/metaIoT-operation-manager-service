package com.upv.alalca3.metaIoT.operationmanager.service;

import com.upv.alalca3.metaIoT.operationmanager.model.Operation;

public interface OperationSchedulerService {

    <E extends Operation> E scheduleOperation(E operation);

    <E extends Operation> void cancelMissionSchedule(E operation);

}