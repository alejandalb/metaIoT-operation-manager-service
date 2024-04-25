/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.factories;

import org.mapstruct.ObjectFactory;

import com.upv.alalca3.metaIoT.operationmanager.model.CustomOperation;
import com.upv.alalca3.metaIoT.operationmanager.model.Operation;
import com.upv.alalca3.metaIoT.operationmanager.model.ScriptOperation;
import com.upv.alalca3.metaIoT.operationmanager.model.UpdateOperation;
import com.upv.alalca3.metaIoT.operationmanager.model.dto.CustomOperationDTO;
import com.upv.alalca3.metaIoT.operationmanager.model.dto.OperationDTO;
import com.upv.alalca3.metaIoT.operationmanager.model.dto.ScriptOperationDTO;
import com.upv.alalca3.metaIoT.operationmanager.model.dto.UpdateOperationDTO;

/**
 * 
 */
public class OperationFactory {
    @ObjectFactory
    public Operation createOperation(OperationDTO operationDTO) {
	if (operationDTO instanceof CustomOperationDTO) {
	    return new CustomOperation();
	} else if (operationDTO instanceof ScriptOperationDTO) {
	    return new ScriptOperation();
	} else if (operationDTO instanceof UpdateOperationDTO) {
	    return new UpdateOperation();
	} else {
	    throw new IllegalArgumentException("Invalid operation type");
	}
    }

    @ObjectFactory
    public OperationDTO createOperationDTO(Operation operation) {
	if (operation instanceof CustomOperation) {
	    return new CustomOperationDTO();
	} else if (operation instanceof ScriptOperation) {
	    return new ScriptOperationDTO();
	} else if (operation instanceof UpdateOperation) {
	    return new UpdateOperationDTO();
	} else {
	    throw new IllegalArgumentException("Invalid operation type");
	}
    }
}
