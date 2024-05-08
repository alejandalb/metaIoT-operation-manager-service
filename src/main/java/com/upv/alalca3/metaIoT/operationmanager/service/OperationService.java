package com.upv.alalca3.metaIoT.operationmanager.service;

import java.util.Optional;

import com.upv.alalca3.metaIoT.operationmanager.model.Operation;
import com.upv.alalca3.metaIoT.operationmanager.model.dto.OperationDTO;

public interface OperationService {

    <E extends Operation, D extends OperationDTO> D save(D dto);

    <D extends OperationDTO> Optional<D> get(Long id);

}