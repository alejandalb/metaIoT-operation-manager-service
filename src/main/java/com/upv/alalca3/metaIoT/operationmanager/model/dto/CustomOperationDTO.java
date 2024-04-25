/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.model.dto;

import java.util.Map;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 */
@Data
@NoArgsConstructor
public class CustomOperationDTO extends OperationDTO {
    private Map<String, Object> parameters;
}
