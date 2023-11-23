/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.config;

import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.upv.alalca3.metaIoT.operationmanager.config.properties.MqttProperties;

@Configuration
public class MqttConfig {

	@Autowired
	private MqttProperties mqttProperties;

	@Bean
	MqttConnectOptions mqttConnectOptions() {
		MqttConnectOptions options = new MqttConnectOptions();
		options.setServerURIs(new String[] { mqttProperties.getBrokerUrl() });
		options.setUserName(mqttProperties.getUsername());
		options.setPassword(mqttProperties.getPassword().toCharArray());
		// You can set additional options here, such as connection timeout, keep-alive
		// interval, etc.
		return options;
	}

	@Bean
	org.eclipse.paho.client.mqttv3.MqttClient mqttClient() throws Exception {
		return new org.eclipse.paho.client.mqttv3.MqttClient(mqttProperties.getBrokerUrl(),
				mqttProperties.getClientId(), new MemoryPersistence());
	}

	public String buildPublishTopic(String additionalPath) {
		return mqttProperties.getTopicsBase().getPublish() + additionalPath;
	}

	public String buildAckTopic(String additionalPath) {
		return mqttProperties.getTopicsBase().getAck() + additionalPath;
	}

	public String buildCompletionTopic(String additionalPath) {
		return mqttProperties.getTopicsBase().getCompletion() + additionalPath;
	}

	public String buildRejectionTopic(String additionalPath) {
		return mqttProperties.getTopicsBase().getRejection() + additionalPath;
	}
}
