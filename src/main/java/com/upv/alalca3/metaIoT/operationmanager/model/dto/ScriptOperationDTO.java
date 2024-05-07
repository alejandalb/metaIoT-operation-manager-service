/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.model.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 */
@Data
@NoArgsConstructor
@JsonTypeName("SCRIPT")
public class ScriptOperationDTO extends OperationDTO {
    private ScriptDTO script;
}
