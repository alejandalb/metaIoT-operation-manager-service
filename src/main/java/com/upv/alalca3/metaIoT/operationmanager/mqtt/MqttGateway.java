/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.mqtt;

import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.upv.alalca3.metaIoT.operationmanager.mqtt.properties.MqttProperties;

/**
 * Component that works as a gateway to the MQTT Broker
 * 
 *
 */
@Component
public class MqttGateway {

	private MqttClient client;

	private final MqttProperties mqttProperties;

	/**
	 * Default constructor
	 * 
	 * @param mqttProperties Mqtt functionality properties
	 */
	@Autowired
	public MqttGateway(MqttProperties mqttProperties) {
		this.mqttProperties = mqttProperties;
		try {

			this.client = new MqttClient(this.mqttProperties.getBroker().getUrl(),
					this.mqttProperties.getClient().getId());
			MqttConnectOptions options = new MqttConnectOptions();
			options.setUserName(this.mqttProperties.getUsername());
			options.setPassword(this.mqttProperties.getPassword().toCharArray());
			options.setAutomaticReconnect(this.mqttProperties.isAutoReconnect());
			this.client.connect(options);
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param topic    topic to be subscribed
	 * @param callback callback method
	 */
	public void subscribe(String topic, MqttCallback callback) {
		try {
			this.client.setCallback(callback);
			this.client.subscribe(topic, this.mqttProperties.getQos());
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param topic   topic to be subscribed
	 * @param payload message to be published
	 */
	public void publish(String topic, String payload) {
		try {
			MqttMessage message = new MqttMessage(payload.getBytes());
			message.setQos(this.mqttProperties.getQos());
			this.client.publish(topic, message);
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}
}
