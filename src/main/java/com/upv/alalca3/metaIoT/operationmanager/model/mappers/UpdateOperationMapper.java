/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.model.mappers;

import org.mapstruct.Mapper;

import com.upv.alalca3.metaIoT.operationmanager.config.MapstructMapperConfig;
import com.upv.alalca3.metaIoT.operationmanager.model.UpdateOperation;
import com.upv.alalca3.metaIoT.operationmanager.model.dto.UpdateOperationDTO;

@Mapper(componentModel = "spring", config = MapstructMapperConfig.class)
public interface UpdateOperationMapper extends OperationMapper<UpdateOperation, UpdateOperationDTO> {
}
