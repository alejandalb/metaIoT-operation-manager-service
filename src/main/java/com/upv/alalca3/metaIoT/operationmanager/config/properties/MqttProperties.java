package com.upv.alalca3.metaIoT.operationmanager.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "mqtt")
public class MqttProperties {

	private MqttTopicsBase topicsBase;
	private String brokerUrl;
	private String clientId;
	private String username;
	private String password;

	// Getters and setters for the properties

	public MqttTopicsBase getTopicsBase() {
		return topicsBase;
	}

	public void setTopicsBase(MqttTopicsBase topicsBase) {
		this.topicsBase = topicsBase;
	}

	public String getBrokerUrl() {
		return brokerUrl;
	}

	public void setBrokerUrl(String brokerUrl) {
		this.brokerUrl = brokerUrl;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static class MqttTopicsBase {
		private String publish;
		private String ack;
		private String completion;
		private String rejection;

		public String getPublish() {
			return publish;
		}

		public void setPublish(String publish) {
			this.publish = publish;
		}

		public String getAck() {
			return ack;
		}

		public void setAck(String ack) {
			this.ack = ack;
		}

		public String getCompletion() {
			return completion;
		}

		public void setCompletion(String completion) {
			this.completion = completion;
		}

		public String getRejection() {
			return rejection;
		}

		public void setRejection(String rejection) {
			this.rejection = rejection;
		}
	}
}
