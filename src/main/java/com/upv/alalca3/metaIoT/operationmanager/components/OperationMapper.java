package com.upv.alalca3.metaIoT.operationmanager.components;

import java.util.List;

import com.upv.alalca3.metaIoT.operationmanager.model.Operation;
import com.upv.alalca3.metaIoT.operationmanager.model.dto.OperationDTO;

public interface OperationMapper {

    <E extends Operation, D extends OperationDTO> D toDto(E entity);

    <E extends Operation, D extends OperationDTO> List<D> toDtos(List<E> entites);

    <E extends Operation, D extends OperationDTO> E toEntity(D dto);

    <E extends Operation, D extends OperationDTO> List<E> toEntities(List<D> dtos);

    <E extends Operation> E merge(E source, E target);

    <D extends OperationDTO> D merge(D source, D target);

}