/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.config.properties;

/**
 * @author gmv Mqtt broker properties
 *
 */
public class BrokerProperties {
	private String url;

	/**
	 * Default constructor
	 */
	public BrokerProperties() {
		super();
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return this.url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
}
