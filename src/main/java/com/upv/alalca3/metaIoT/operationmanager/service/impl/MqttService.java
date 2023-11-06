package com.upv.alalca3.metaIoT.operationmanager.service.impl;

import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upv.alalca3.metaIoT.operationmanager.config.MqttConfig;
import com.upv.alalca3.metaIoT.operationmanager.service.IMqttService;

@Service
public class MqttService implements IMqttService {

	@Autowired
	private MqttClient mqttClient;

	@Autowired
	private MqttConfig mqttConfig;

	public void publishOperation(String additionalPath, String message) throws MqttException {
		String topic = mqttConfig.buildPublishTopic(additionalPath);
		publishMessage(topic, message);
	}

	public void subscribeToAckTopic(IMqttMessageListener listener) throws MqttException {
		String topic = mqttConfig.buildAckTopic("#"); // Subscribe to all subtopics under "ack"
		subscribeToTopic(topic, listener);
	}

	public void subscribeToCompletionTopic(IMqttMessageListener listener) throws MqttException {
		String topic = mqttConfig.buildCompletionTopic("#"); // Subscribe to all subtopics under "completion"
		subscribeToTopic(topic, listener);
	}

	public void subscribeToRejectionTopic(IMqttMessageListener listener) throws MqttException {
		String topic = mqttConfig.buildRejectionTopic("#"); // Subscribe to all subtopics under "rejection"
		subscribeToTopic(topic, listener);
	}

	private void subscribeToTopic(String topic, IMqttMessageListener listener) throws MqttException {
		mqttClient.connect();
		mqttClient.subscribe(topic, 0, listener);
	}

	public void publishMessage(String topic, String message) throws MqttException {
		mqttClient.connect();
		mqttClient.publish(topic, message.getBytes(), 0, false);
		mqttClient.disconnect();
	}
}
