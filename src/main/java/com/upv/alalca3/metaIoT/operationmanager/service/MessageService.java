package com.upv.alalca3.metaIoT.operationmanager.service;

import java.util.List;

import com.upv.alalca3.metaIoT.operationmanager.model.dto.MessageDTO;

public interface MessageService {

    void save(Long operationId, MessageDTO dto);

    List<MessageDTO> getMessagesByOperationId(Long operationId);

}