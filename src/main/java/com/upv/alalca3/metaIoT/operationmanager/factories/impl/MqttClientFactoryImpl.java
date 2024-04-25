/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.factories.impl;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MqttDefaultFilePersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.upv.alalca3.metaIoT.operationmanager.config.properties.MqttProperties;
import com.upv.alalca3.metaIoT.operationmanager.factories.MqttClientFactory;

/**
 * {@link MqttClientFactory} implementation
 */
@Component
public class MqttClientFactoryImpl implements MqttClientFactory {

	private static final Logger LOGGER = LoggerFactory.getLogger(MqttClientFactoryImpl.class);

	private static final String PERSISTENCE_PATH = "mqtt";

	/**
	 * Creates a MqttClient
	 * 
	 * @param properties The properties for connecting to the MqttBroker and message
	 *                   publishing
	 * @return the new MqttClient
	 */
	@Override
	public IMqttClient create(MqttProperties properties) {
		try {
			String clientId = properties.getClient().getId();
			MqttDefaultFilePersistence persistence = new MqttDefaultFilePersistence(PERSISTENCE_PATH);
			LOGGER.info("Creating MqttClient with [clientId: {}, url: {}", clientId, properties.getBroker().getUrl());
			return new MqttClient(properties.getBroker().getUrl(), clientId, persistence);
		} catch (MqttException | IllegalArgumentException e) {
			LOGGER.error("Error creating the MQTT client", e);
			return null;
		}
	}

	/**
	 * Connect to the MqttBroker
	 * 
	 * @param client     client instance that will connect
	 * @param properties properties of the mqtt connection
	 */
	@Override
	public void connect(IMqttClient client, MqttProperties properties) {
		try {
			MqttConnectOptions options = new MqttConnectOptions();
			options.setAutomaticReconnect(properties.isAutoReconnect());
			options.setCleanSession(false);
			client.connect(options);
			LOGGER.info("Connected to the MQTT Broker");
		} catch (MqttException ignored) {
			LOGGER.error("Error connecting to the MQTT Broker", ignored);
		}
	}

}
