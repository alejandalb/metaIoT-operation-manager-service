/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 */
@Data
@NoArgsConstructor
public class ScriptOperationDTO extends OperationDTO {
    private ScriptDTO script;
}
