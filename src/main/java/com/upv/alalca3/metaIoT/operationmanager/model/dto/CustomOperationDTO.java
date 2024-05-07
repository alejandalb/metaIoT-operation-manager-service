/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.model.dto;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 */
@Data
@NoArgsConstructor
@JsonTypeName("CUSTOM")
public class CustomOperationDTO extends OperationDTO {
    private Map<String, Object> parameters;
}
