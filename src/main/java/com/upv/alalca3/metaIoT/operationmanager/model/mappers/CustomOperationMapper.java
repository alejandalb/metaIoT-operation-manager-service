/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.model.mappers;

import org.mapstruct.Mapper;

import com.upv.alalca3.metaIoT.operationmanager.config.MapstructMapperConfig;
import com.upv.alalca3.metaIoT.operationmanager.factories.OperationFactory;
import com.upv.alalca3.metaIoT.operationmanager.model.CustomOperation;
import com.upv.alalca3.metaIoT.operationmanager.model.dto.CustomOperationDTO;

@Mapper(componentModel = "spring", config = MapstructMapperConfig.class, uses = OperationFactory.class)
public interface CustomOperationMapper extends OperationMapper<CustomOperation, CustomOperationDTO> {
}
