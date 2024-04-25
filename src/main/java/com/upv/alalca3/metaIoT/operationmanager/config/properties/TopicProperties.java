/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.config.properties;

/**
 * @author alejandalb Mqtt topic properties
 */
public class TopicProperties {

	private String publish;
	private String ack;
	private String completion;
	private String rejection;

	/**
	 * Default constructor
	 */
	public TopicProperties() {
		super();
	}

	/**
	 * @return the publish
	 */
	public String getPublish() {
		return this.publish;
	}

	/**
	 * @param publish the publish to set
	 */
	public void setPublish(String publish) {
		this.publish = publish;
	}

	/**
	 * @return the ack
	 */
	public String getAck() {
		return this.ack;
	}

	/**
	 * @param ack the ack to set
	 */
	public void setAck(String ack) {
		this.ack = ack;
	}

	/**
	 * @return the completion
	 */
	public String getCompletion() {
		return this.completion;
	}

	/**
	 * @param completion the completion to set
	 */
	public void setCompletion(String completion) {
		this.completion = completion;
	}

	/**
	 * @return the rejection
	 */
	public String getRejection() {
		return this.rejection;
	}

	/**
	 * @param rejection the rejection to set
	 */
	public void setRejection(String rejection) {
		this.rejection = rejection;
	}
}
