/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

/**
 * 
 */
@Entity
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long operation_id;

    private String operation_type;
    private String operation_parameters;
    private String operation_status;

    @OneToMany(mappedBy = "operation")
    private Set<Message> messages;
    
    

	/**
	 * @return the operation_id
	 */
	public Long getOperation_id() {
		return operation_id;
	}

	/**
	 * @param operation_id the operation_id to set
	 */
	public void setOperation_id(Long operation_id) {
		this.operation_id = operation_id;
	}

	/**
	 * @return the operation_type
	 */
	public String getOperation_type() {
		return operation_type;
	}

	/**
	 * @param operation_type the operation_type to set
	 */
	public void setOperation_type(String operation_type) {
		this.operation_type = operation_type;
	}

	/**
	 * @return the operation_parameters
	 */
	public String getOperation_parameters() {
		return operation_parameters;
	}

	/**
	 * @param operation_parameters the operation_parameters to set
	 */
	public void setOperation_parameters(String operation_parameters) {
		this.operation_parameters = operation_parameters;
	}

	/**
	 * @return the operation_status
	 */
	public String getOperation_status() {
		return operation_status;
	}

	/**
	 * @param operation_status the operation_status to set
	 */
	public void setOperation_status(String operation_status) {
		this.operation_status = operation_status;
	}

	/**
	 * @return the messages
	 */
	public Set<Message> getMessages() {
		return messages;
	}

	/**
	 * @param messages the messages to set
	 */
	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}
    
    
}
