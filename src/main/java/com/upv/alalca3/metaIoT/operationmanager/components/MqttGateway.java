package com.upv.alalca3.metaIoT.operationmanager.components;

import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;

public interface MqttGateway {
	/**
	 * Publishes the payload on the specified Mqtt topic
	 * 
	 * @param topic   topic to be subscribed
	 * @param payload message to be published
	 */
	void publish(String topic, String payload);

	/**
	 * Sets the {@link MqttClient}'s callback and subscribes to a list of
	 * topicFilters
	 * 
	 * @param topicFilters array of String containing all the topicFilters the
	 *                     {@link MqttClient} should subscribe
	 * @param callback     the client's {@link MqttCallback} to be assigned for
	 *                     incoming messages
	 */
	void subscribe(String[] topicFilters, MqttCallback callback);
}