/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.service;

import org.eclipse.paho.client.mqttv3.MqttCallback;

/**
 * 
 */
public interface MqttService {

	void publishOperation(String additionalPath, String message);

	void subscribeToAckTopic(MqttCallback callback);

	void subscribeToCompletionTopic(MqttCallback callback);

	void subscribeToRejectionTopic(MqttCallback callback);

	/**
	 * Subscribes to the specified MQTT topics.
	 *
	 * @param topics the topics to subscribe to
	 */
	void subscribe();

}
