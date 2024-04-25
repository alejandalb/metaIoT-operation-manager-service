/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.mqtt.impl;

import java.util.Arrays;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.upv.alalca3.metaIoT.operationmanager.config.properties.MqttProperties;
import com.upv.alalca3.metaIoT.operationmanager.factories.MqttClientFactory;
import com.upv.alalca3.metaIoT.operationmanager.mqtt.MqttGateway;

import jakarta.annotation.PostConstruct;

/**
 * Component that works as a gateway to the MQTT Broker
 * 
 *
 */
@Component
public class MqttGatewayImpl implements MqttGateway {
    private static final Logger LOGGER = LoggerFactory.getLogger(MqttGatewayImpl.class);

    private IMqttClient client;

    private MqttClientFactory mqttClientFactory;

    private final MqttProperties mqttProperties;

    /**
     * Default constructor
     * 
     * @param mqttProperties    Mqtt functionality properties
     * @param mqttClientFactory Mqtt client factory
     */
    @Autowired
    public MqttGatewayImpl(MqttProperties mqttProperties, MqttClientFactory mqttClientFactory) {
	this.mqttProperties = mqttProperties;
	this.mqttClientFactory = mqttClientFactory;
	this.client = mqttClientFactory.create(mqttProperties);

    }

    @PostConstruct
    protected void connect() {
	this.mqttClientFactory.connect(this.client, this.mqttProperties);
    }

    @Override
    public void subscribe(String[] topicFilters, MqttCallback callback) {
	this.client.setCallback(callback);
	int[] qos = new int[topicFilters.length];
	Arrays.fill(qos, this.mqttProperties.getQos());
	try {
	    this.client.subscribe(topicFilters, qos);
	    LOGGER.info("Subscribed to MQTT topics [{}] with QOS {}", topicFilters, this.mqttProperties.getQos());
	} catch (MqttException e) {
	    LOGGER.error("Error subscribing to MQTT Broker", e);
	}
    }

    @Override
    public void publish(String topic, String payload) {
	MqttMessage message = new MqttMessage(payload.getBytes());
	message.setQos(this.mqttProperties.getQos());
	message.setRetained(true);
	try {
	    this.client.publish(topic, message);
	    LOGGER.debug("Message published in MQTT topic [{}]: {}", topic, payload);
	} catch (MqttException ignored) {
	    LOGGER.error("Error publishing message in MQTT topic [{}]", topic);
	}
    }
}
