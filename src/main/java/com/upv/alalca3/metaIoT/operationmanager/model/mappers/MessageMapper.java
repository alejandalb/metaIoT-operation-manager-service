/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.model.mappers;

import java.util.Collection;
import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.upv.alalca3.metaIoT.operationmanager.config.MapstructMapperConfig;
import com.upv.alalca3.metaIoT.operationmanager.model.Message;
import com.upv.alalca3.metaIoT.operationmanager.model.dto.MessageDTO;

@Mapper(componentModel = "spring", config = MapstructMapperConfig.class)
public interface MessageMapper {
    MessageDTO toDto(Message entity);

    List<MessageDTO> toDtos(Collection<Message> entities);

    @InheritInverseConfiguration
    Message toEntity(MessageDTO dto);

    List<Message> toEntities(Collection<MessageDTO> dtos);

    Message merge(Message source, @MappingTarget Message target);

    MessageDTO merge(MessageDTO source, @MappingTarget MessageDTO target);
}
