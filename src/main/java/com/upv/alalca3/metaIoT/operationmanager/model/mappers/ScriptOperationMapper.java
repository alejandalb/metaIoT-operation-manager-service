/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.model.mappers;

import org.mapstruct.Mapper;

import com.upv.alalca3.metaIoT.operationmanager.config.MapstructMapperConfig;
import com.upv.alalca3.metaIoT.operationmanager.factories.OperationFactory;
import com.upv.alalca3.metaIoT.operationmanager.model.ScriptOperation;
import com.upv.alalca3.metaIoT.operationmanager.model.dto.ScriptOperationDTO;

@Mapper(componentModel = "spring", config = MapstructMapperConfig.class, uses = OperationFactory.class)
public interface ScriptOperationMapper extends OperationMapper<ScriptOperation, ScriptOperationDTO> {
}
