/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.model.dto;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.upv.alalca3.metaIoT.operationmanager.utils.enums.OperationStatus;
import com.upv.alalca3.metaIoT.operationmanager.utils.enums.OperationType;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for {@link Operation}
 */
@Data
@NoArgsConstructor
@JsonTypeInfo(use = Id.NAME, include = As.EXISTING_PROPERTY, property = "type", visible = true)
@JsonSubTypes({ @JsonSubTypes.Type(value = CustomOperationDTO.class, name = "CUSTOM"),
	@JsonSubTypes.Type(value = ScriptOperationDTO.class, name = "SCRIPT"),
	@JsonSubTypes.Type(value = UpdateOperationDTO.class, name = "UPDATE") })
public class OperationDTO {
    private Long id;
    private OperationType type;
    private OperationStatus status;
    private OperationTargetDeviceDataDTO targetDevice;
    private OperationSchedulingDataDTO schedulingData;
    private Instant creationDate;
    private Instant modificationDate;
}
