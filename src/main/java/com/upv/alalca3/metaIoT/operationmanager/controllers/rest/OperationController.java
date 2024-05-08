/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.upv.alalca3.metaIoT.operationmanager.model.dto.MessageDTO;
import com.upv.alalca3.metaIoT.operationmanager.model.dto.OperationDTO;
import com.upv.alalca3.metaIoT.operationmanager.service.MessageService;
import com.upv.alalca3.metaIoT.operationmanager.service.OperationService;

/**
 *
 */
@RestController
public class OperationController {
    private final OperationService operationService;
    private final MessageService messageService;

    /**
     * @param operationService
     * @param messageService
     */
    @Autowired
    public OperationController(OperationService operationService, MessageService messageService) {
	super();
	this.operationService = operationService;
	this.messageService = messageService;
    }

    @PostMapping("/op/publish")
    public <D extends OperationDTO> ResponseEntity<D> publishOperation(@RequestBody D operation) {
	return ResponseEntity.ok(this.operationService.save(operation));
    }

    @GetMapping("/op/{id}")
    public <D extends OperationDTO> ResponseEntity<D> get(@PathVariable Long id) {
	return ResponseEntity.of(this.operationService.get(id));
    }

    @GetMapping("/op/{id}/messages")
    public <D extends OperationDTO> ResponseEntity<List<MessageDTO>> getMessages(@PathVariable Long id) {
	return ResponseEntity.ok(this.messageService.getMessagesByOperationId(id));
    }
}
