/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.model.mappers;

import java.util.Collection;
import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.MappingTarget;

import com.upv.alalca3.metaIoT.operationmanager.model.Operation;
import com.upv.alalca3.metaIoT.operationmanager.model.dto.OperationDTO;

/**
 * 
 */
public interface OperationMapper<E extends Operation, D extends OperationDTO> {
    D toDto(E entity);

    List<D> toDtos(Collection<E> entities);

    @InheritInverseConfiguration
    E toEntity(D dto);

    List<E> toEntities(Collection<D> dtos);

    E merge(E source, @MappingTarget E target);

    D merge(D source, @MappingTarget D target);
}
