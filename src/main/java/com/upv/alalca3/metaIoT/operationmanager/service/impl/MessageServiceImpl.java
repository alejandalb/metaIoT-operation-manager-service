/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.service.impl;

import java.util.List;
import java.util.Optional;

import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upv.alalca3.metaIoT.operationmanager.model.Message;
import com.upv.alalca3.metaIoT.operationmanager.model.Operation;
import com.upv.alalca3.metaIoT.operationmanager.model.dto.MessageDTO;
import com.upv.alalca3.metaIoT.operationmanager.model.mappers.MessageMapper;
import com.upv.alalca3.metaIoT.operationmanager.repositories.jpa.MessageRepository;
import com.upv.alalca3.metaIoT.operationmanager.repositories.jpa.OperationRepository;
import com.upv.alalca3.metaIoT.operationmanager.service.MessageService;

/**
 * 
 */
@Service
public class MessageServiceImpl implements MessageService {
    private final MessageRepository repository;
    private final MessageMapper mapper;
    private final OperationRepository operationRepository;

    /**
     * Default constructor
     * 
     * @param repository
     * @param mapper
     * @param operationRepository
     */
    @Autowired
    public MessageServiceImpl(MessageRepository repository, MessageMapper mapper,
	    OperationRepository operationRepository) {
	super();
	this.repository = repository;
	this.mapper = mapper;
	this.operationRepository = operationRepository;
    }

    @Override
    public void save(Long operationId, MessageDTO dto) {
	Optional<Operation> optionalOperation = this.operationRepository.findById(operationId);
	if (!optionalOperation.isEmpty()) {
	    Operation operation = optionalOperation.get();
	    Message newEntity = this.mapper.toEntity(dto);
	    newEntity.setOperation(operation);
	    this.repository.save(newEntity);
	} else {
	    throw new OpenApiResourceNotFoundException("No operation was found with the provided id");
	}
    }

    @Override
    public List<MessageDTO> getMessagesByOperationId(Long operationId) {
	return this.mapper.toDtos(this.repository.findByOperationId(operationId));
    }

}
