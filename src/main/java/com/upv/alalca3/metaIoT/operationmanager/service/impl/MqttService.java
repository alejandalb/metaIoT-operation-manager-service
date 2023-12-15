package com.upv.alalca3.metaIoT.operationmanager.service.impl;

import java.nio.charset.StandardCharsets;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.upv.alalca3.metaIoT.operationmanager.model.Message;
import com.upv.alalca3.metaIoT.operationmanager.model.jpa.MessageRepository;
import com.upv.alalca3.metaIoT.operationmanager.mqtt.MqttGateway;
import com.upv.alalca3.metaIoT.operationmanager.mqtt.properties.MqttProperties;
import com.upv.alalca3.metaIoT.operationmanager.service.IMqttService;

@Service
public class MqttService implements IMqttService {
	private static final Logger LOGGER = LoggerFactory.getLogger(MqttService.class);

	private final MqttProperties mqttProperties;

	private final MqttGateway mqttGateway;

	@Autowired
	private MessageRepository messageRepository;

	@Autowired
	public MqttService(MqttProperties mqttProperties, MqttGateway mqttGateway) {
		super();
		this.mqttProperties = mqttProperties;
		this.mqttGateway = mqttGateway;
	}

	/**
	 * Subscribes to the specified MQTT topics.
	 *
	 * @param topics the topics to subscribe to
	 */
	@Override
	public void subscribe() {
		MqttCallbackExtended callback = new MqttCallbackExtended() {
			@Override
			public void connectComplete(boolean reconnect, String serverURI) {
				if (reconnect) {
					LOGGER.info("Reconnected to broker");
					// Because Clean Session is set to true, we need to re-subscribe
					MqttService.this.subscribeToAckTopic(this);
					MqttService.this.subscribeToCompletionTopic(this);
					MqttService.this.subscribeToRejectionTopic(this);
				} else {
					LOGGER.info("Connected to broker");
				}
			}

			@Override
			public void connectionLost(Throwable cause) {
				LOGGER.error("Connection lost", cause);
			}

			@Override
			public void messageArrived(String topic, MqttMessage message) throws Exception {
				MqttService.this.handleMessage(topic, message);
			}

			@Override
			public void deliveryComplete(IMqttDeliveryToken token) {
				LOGGER.info("Delivery complete");
			}
		};

		this.subscribeToAckTopic(callback);
		this.subscribeToCompletionTopic(callback);
		this.subscribeToRejectionTopic(callback);
	}

	@Override
	public void publishOperation(String additionalPath, String message) {
		String topic = this.buildPublishTopic(additionalPath);
		this.publishMessage(topic, message);
	}

	@Override
	public void subscribeToAckTopic(MqttCallback callback) {
		String topic = this.buildAckTopic("#"); // Subscribe to all subtopics under "ack"
		this.subscribeToTopic(topic, callback);
		LOGGER.info("Suscribed to:" + topic);
	}

	@Override
	public void subscribeToCompletionTopic(MqttCallback callback) {
		String topic = this.buildCompletionTopic("#"); // Subscribe to all subtopics under "completion"
		this.subscribeToTopic(topic, callback);
		LOGGER.info("Suscribed to:" + topic);
	}

	@Override
	public void subscribeToRejectionTopic(MqttCallback callback) {
		String topic = this.buildRejectionTopic("#"); // Subscribe to all subtopics under "rejection"
		this.subscribeToTopic(topic, callback);
		LOGGER.info("Suscribed to:" + topic);
	}

	private void subscribeToTopic(String topic, MqttCallback callback) {
		this.mqttGateway.subscribe(topic, callback);
	}

	private void publishMessage(String topic, String message) {
		this.mqttGateway.publish(topic, message);
	}

	private String buildPublishTopic(String additionalPath) {
		return this.mqttProperties.getTopics().getPublish() + additionalPath;
	}

	private String buildAckTopic(String additionalPath) {
		return this.mqttProperties.getTopics().getAck() + additionalPath;
	}

	private String buildCompletionTopic(String additionalPath) {
		return this.mqttProperties.getTopics().getCompletion() + additionalPath;
	}

	private String buildRejectionTopic(String additionalPath) {
		return this.mqttProperties.getTopics().getRejection() + additionalPath;
	}

	private void handleMessage(String topic, MqttMessage message) {
		if (topic.startsWith(this.mqttProperties.getTopics().getAck())) {
			this.storeMessage("ACK", message);
		} else if (topic.startsWith(this.mqttProperties.getTopics().getCompletion())) {
			this.storeMessage("COMPLETED", message);
		} else if (topic.startsWith(this.mqttProperties.getTopics().getRejection())) {
			this.storeMessage("REJECTED", message);

		}
	}

	private void storeMessage(String type, MqttMessage message) {
		ObjectMapper mapper = new ObjectMapper();
		Message m = null;
		try {
			m = mapper.readValue(new String(message.getPayload(), StandardCharsets.UTF_8), Message.class);
			m.setType(type);

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		if (m != null) {
			this.messageRepository.save(m);
		}
	}

}
