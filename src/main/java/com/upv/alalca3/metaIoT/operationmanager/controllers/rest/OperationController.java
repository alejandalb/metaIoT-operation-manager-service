/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.upv.alalca3.metaIoT.operationmanager.model.dto.OperationDTO;
import com.upv.alalca3.metaIoT.operationmanager.service.MqttService;
import com.upv.alalca3.metaIoT.operationmanager.service.OperationService;

/**
 *
 */
@RestController
public class OperationController {
    @Autowired
    private MqttService mqttService;
    @Autowired
    private OperationService opService;

    @PostMapping("/op/publish")
    public <D extends OperationDTO> ResponseEntity<Void> publishOperation(@RequestBody D operation) {
	this.opService.save(operation);
	return ResponseEntity.ok().build();
    }
}
