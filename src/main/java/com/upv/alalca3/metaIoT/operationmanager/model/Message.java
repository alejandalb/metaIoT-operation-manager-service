/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * @author amna
 *
 */
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long message_id;

    @ManyToOne
    @JoinColumn(name = "operation_id")
    private Operation operation;

    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device;

    private String message_content;
    private String message_type;
	/**
	 * @return the message_id
	 */
	public Long getMessage_id() {
		return message_id;
	}
	/**
	 * @param message_id the message_id to set
	 */
	public void setMessage_id(Long message_id) {
		this.message_id = message_id;
	}
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
	/**
	 * @return the message_content
	 */
	public String getMessage_content() {
		return message_content;
	}
	/**
	 * @param message_content the message_content to set
	 */
	public void setMessage_content(String message_content) {
		this.message_content = message_content;
	}
	/**
	 * @return the message_type
	 */
	public String getMessage_type() {
		return message_type;
	}
	/**
	 * @param message_type the message_type to set
	 */
	public void setMessage_type(String message_type) {
		this.message_type = message_type;
	}
    
    
}
