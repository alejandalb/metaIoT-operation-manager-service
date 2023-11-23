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
 * @author amna
 *
 */
@Entity
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long device_id;

    private String device_name;

    // Add other device-specific fields here

    @OneToMany(mappedBy = "device")
    private Set<Message> messages;

	/**
	 * @return the device_id
	 */
	public Long getDevice_id() {
		return device_id;
	}

	/**
	 * @param device_id the device_id to set
	 */
	public void setDevice_id(Long device_id) {
		this.device_id = device_id;
	}

	/**
	 * @return the device_name
	 */
	public String getDevice_name() {
		return device_name;
	}

	/**
	 * @param device_name the device_name to set
	 */
	public void setDevice_name(String device_name) {
		this.device_name = device_name;
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
