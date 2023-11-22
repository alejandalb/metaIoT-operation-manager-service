package com.upv.alalca3.metaIoT.operationmanager.service.impl;

import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RejectionListenerService {

	@Autowired
	private MqttService mqttService;

	public RejectionListenerService() {
		// Subscribe to the "rejection" topic when this service is instantiated
		subscribe();
	}

	private void subscribe() {
		try {
			mqttService.subscribeToRejectionTopic(new IMqttMessageListener() {
				@Override
				public void messageArrived(String topic, MqttMessage message) throws Exception {
					// Handle the incoming message from the "ack" topic
					String payload = new String(message.getPayload());
					System.out.println("Received message on 'rejection' topic: " + payload);
				}
			});
		} catch (MqttException e) {
			// Handle any exceptions related to MQTT subscription
			e.printStackTrace();
		}
	}
}
