/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.upv.alalca3.metaIoT.operationmanager.model.Operation;
import com.upv.alalca3.metaIoT.operationmanager.service.MqttService;
import com.upv.alalca3.metaIoT.operationmanager.service.impl.OperationServiceImpl;

/**
 *
 */
@RestController
public class OperationController {
    @Autowired
    private MqttService mqttService;
    @Autowired
    private OperationServiceImpl opService;

    @PostMapping("/op/publish")
    public ResponseEntity<Void> publishOperation(@RequestBody Operation operation) {
	this.opService.save(null);
	return ResponseEntity.ok().build();
    }
}
