/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.components.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.upv.alalca3.metaIoT.operationmanager.components.OperationMapper;
import com.upv.alalca3.metaIoT.operationmanager.model.CustomOperation;
import com.upv.alalca3.metaIoT.operationmanager.model.Operation;
import com.upv.alalca3.metaIoT.operationmanager.model.ScriptOperation;
import com.upv.alalca3.metaIoT.operationmanager.model.UpdateOperation;
import com.upv.alalca3.metaIoT.operationmanager.model.dto.CustomOperationDTO;
import com.upv.alalca3.metaIoT.operationmanager.model.dto.OperationDTO;
import com.upv.alalca3.metaIoT.operationmanager.model.dto.ScriptOperationDTO;
import com.upv.alalca3.metaIoT.operationmanager.model.dto.UpdateOperationDTO;
import com.upv.alalca3.metaIoT.operationmanager.model.mappers.BaseOperationMapper;
import com.upv.alalca3.metaIoT.operationmanager.model.mappers.CustomOperationMapper;
import com.upv.alalca3.metaIoT.operationmanager.model.mappers.ScriptOperationMapper;
import com.upv.alalca3.metaIoT.operationmanager.model.mappers.UpdateOperationMapper;

/**
 * 
 */
@Component
public class OperationMapperImpl implements OperationMapper {
    private CustomOperationMapper customMapper;
    private ScriptOperationMapper scriptMapper;
    private UpdateOperationMapper updateMapper;

    private final Map<Class<?>, BaseOperationMapper<? extends Operation, ? extends OperationDTO>> mappers = new HashMap<>();

    /**
     * Default constructor
     * 
     * @param customMapper
     * @param scriptMapper
     * @param updateMapper
     */
    public OperationMapperImpl(CustomOperationMapper customMapper, ScriptOperationMapper scriptMapper,
	    UpdateOperationMapper updateMapper) {
	this.customMapper = customMapper;
	this.scriptMapper = scriptMapper;
	this.updateMapper = updateMapper;
	this.initEntityMappers();
	this.initDTOMappers();
    }

    protected void initEntityMappers() {
	this.mappers.put(CustomOperation.class, this.customMapper);
	this.mappers.put(ScriptOperation.class, this.scriptMapper);
	this.mappers.put(UpdateOperation.class, this.updateMapper);
    }

    protected void initDTOMappers() {
	this.mappers.put(CustomOperationDTO.class, this.customMapper);
	this.mappers.put(ScriptOperationDTO.class, this.scriptMapper);
	this.mappers.put(UpdateOperationDTO.class, this.updateMapper);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <E extends Operation, D extends OperationDTO> D toDto(E entity) {
	BaseOperationMapper<E, D> mapper = (BaseOperationMapper<E, D>) this.mappers.get(entity.getClass());
	return mapper.toDto(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <E extends Operation, D extends OperationDTO> List<D> toDtos(List<E> entites) {
	BaseOperationMapper<E, D> mapper = (BaseOperationMapper<E, D>) this.mappers
		.get(entites.iterator().next().getClass());
	return mapper.toDtos(entites);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <E extends Operation, D extends OperationDTO> E toEntity(D dto) {
	BaseOperationMapper<E, D> mapper = (BaseOperationMapper<E, D>) this.mappers.get(dto.getClass());
	return mapper.toEntity(dto);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <E extends Operation, D extends OperationDTO> List<E> toEntities(List<D> dtos) {
	BaseOperationMapper<E, D> mapper = (BaseOperationMapper<E, D>) this.mappers
		.get(dtos.iterator().next().getClass());
	return mapper.toEntities(dtos);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <E extends Operation> E merge(E source, E target) {
	BaseOperationMapper<E, ?> mapper = (BaseOperationMapper<E, ?>) this.mappers.get(source.getClass());
	return mapper.merge(source, target);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <D extends OperationDTO> D merge(D source, D target) {
	BaseOperationMapper<?, D> mapper = (BaseOperationMapper<?, D>) this.mappers.get(source.getClass());
	return mapper.merge(source, target);
    }

}
