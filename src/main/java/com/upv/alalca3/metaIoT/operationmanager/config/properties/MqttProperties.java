package com.upv.alalca3.metaIoT.operationmanager.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

/**
 * @author gmv Mqtt functionality properties
 *
 */
@Configuration
@ConfigurationProperties(prefix = "mqtt")
@Validated
public class MqttProperties {

	private TopicProperties topics;
	private BrokerProperties broker;
	private ClientProperties client;
	private String username;
	private String password;
	private int qos;
	private boolean autoReconnect;

	/**
	 * @return the topics
	 */
	public TopicProperties getTopics() {
		return this.topics;
	}

	/**
	 * @param topics the topics to set
	 */
	public void setTopics(TopicProperties topics) {
		this.topics = topics;
	}

	/**
	 * @return the broker
	 */
	public BrokerProperties getBroker() {
		return this.broker;
	}

	/**
	 * @param broker the broker to set
	 */
	public void setBroker(BrokerProperties broker) {
		this.broker = broker;
	}

	/**
	 * @return the client
	 */
	public ClientProperties getClient() {
		return this.client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(ClientProperties client) {
		this.client = client;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the qos
	 */
	public int getQos() {
		return this.qos;
	}

	/**
	 * @param qos the qos to set
	 */
	public void setQos(int qos) {
		this.qos = qos;
	}

	/**
	 * @return the autoReconnect
	 */
	public boolean isAutoReconnect() {
		return this.autoReconnect;
	}

	/**
	 * @param autoReconnect the autoReconnect to set
	 */
	public void setAutoReconnect(boolean autoReconnect) {
		this.autoReconnect = autoReconnect;
	}
}
