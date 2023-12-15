/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.mqtt.properties;

/**
 * @author gmv Mqtt client properties
 *
 */
public class ClientProperties {
	private String id;

	/**
	 * Default constructor
	 */
	public ClientProperties() {
		super();
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
}
