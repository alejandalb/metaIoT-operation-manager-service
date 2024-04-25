/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.factories;

import org.eclipse.paho.client.mqttv3.IMqttClient;

import com.upv.alalca3.metaIoT.operationmanager.config.properties.MqttProperties;

/**
 * Interface for creating Mqtt clients
 * 
 *
 */
public interface MqttClientFactory {
	/**
	 * Creates a MqttClient
	 * 
	 * @param properties The properties for connecting to the mqtt broker and
	 *                   message publishing
	 * @return the new MqttClient
	 */
	IMqttClient create(MqttProperties properties);

	/**
	 * Connect to the MqttBroker
	 * 
	 * @param client     client instance that will connect
	 * @param properties properties of the mqtt connection
	 */
	public void connect(IMqttClient client, MqttProperties properties);
}
