/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.service.impl;

import org.springdoc.core.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upv.alalca3.metaIoT.operationmanager.model.dto.OperationDTO;
import com.upv.alalca3.metaIoT.operationmanager.repositories.jpa.OperationRepository;
import com.upv.alalca3.metaIoT.operationmanager.service.MqttService;

/**
 * Implementation of {@link OperationService}
 */
@Service
public class OperationServiceImpl {
    @Autowired
    private MqttService mqttService;
    @Autowired
    private OperationRepository repository;

    public OperationDTO save(OperationDTO dto) {
	return null;
    }
}
