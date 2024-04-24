/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.upv.alalca3.metaIoT.operationmanager.model.Operation;
import com.upv.alalca3.metaIoT.operationmanager.repositories.jpa.OperationRepository;
import com.upv.alalca3.metaIoT.operationmanager.service.MqttService;

/**
 * @author amna
 *
 */
@Service
public class OperationServiceImpl {
	@Autowired
	private MqttService mqttService;
	@Autowired
	private OperationRepository repo;

	public void handleNewOperation(Operation operation) throws JsonProcessingException {
		operation = this.repo.save(operation);
		this.publishOperation(operation);
	}

	private void publishOperation(Operation operation) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		this.mqttService.publishOperation(operation.getType() + "/" + operation.getId().toString(),
				mapper.writeValueAsString(operation));
	}
}
