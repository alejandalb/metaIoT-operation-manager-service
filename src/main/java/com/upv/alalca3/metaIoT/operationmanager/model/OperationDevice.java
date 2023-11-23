/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 *
 */
@Entity
public class OperationDevice {
    @Id
    @ManyToOne
    @JoinColumn(name = "operation_id")
    private Operation operation;

    @Id
    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device;

	/**
	 * @return the operation
	 */
	public Operation getOperation() {
		return operation;
	}

	/**
	 * @param operation the operation to set
	 */
	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	/**
	 * @return the device
	 */
	public Device getDevice() {
		return device;
	}

	/**
	 * @param device the device to set
	 */
	public void setDevice(Device device) {
		this.device = device;
	}
    
    
}
