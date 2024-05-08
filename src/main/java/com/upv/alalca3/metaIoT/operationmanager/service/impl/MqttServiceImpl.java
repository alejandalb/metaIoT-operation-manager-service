package com.upv.alalca3.metaIoT.operationmanager.service.impl;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.upv.alalca3.metaIoT.operationmanager.components.MqttGateway;
import com.upv.alalca3.metaIoT.operationmanager.config.properties.MqttProperties;
import com.upv.alalca3.metaIoT.operationmanager.model.dto.MessageDTO;
import com.upv.alalca3.metaIoT.operationmanager.model.dto.OperationDTO;
import com.upv.alalca3.metaIoT.operationmanager.service.MessageService;
import com.upv.alalca3.metaIoT.operationmanager.service.MqttService;
import com.upv.alalca3.metaIoT.operationmanager.utils.MqttTopicUtils;
import com.upv.alalca3.metaIoT.operationmanager.utils.enums.MessageType;

import jakarta.annotation.PostConstruct;

@Service
public class MqttServiceImpl implements MqttService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MqttServiceImpl.class);
    private static final String PLUS_WILDCARD = "+";
    private static final String PLUS_WILDCARD_REGEX = "(\\d+)";
    private final Map<String, BiConsumer<String, MqttMessage>> handlers;
    private final ObjectMapper mapper;

    private final MqttGateway mqttGateway;
    private final MqttProperties mqttProperties;
    private final MessageService messageService;

    private Pattern ackPattern;
    private Pattern completedPattern;
    private Pattern rejectedPattern;

    @Autowired
    public MqttServiceImpl(MqttGateway mqttGateway, MqttProperties mqttProperties, MessageService messageService) {
	super();
	this.mqttProperties = mqttProperties;
	this.mqttGateway = mqttGateway;
	this.messageService = messageService;
	this.handlers = new HashMap<>();
	this.mapper = new ObjectMapper();
    }

    @PostConstruct
    protected void init() {
	this.initHandlers();
	this.initPatterns();
	this.configureMapper();
	this.initListener();
    }

    private void initHandlers() {
	this.handlers.put(this.mqttProperties.getTopics().getAck() + "#", this::handleAckMessage);
	this.handlers.put(this.mqttProperties.getTopics().getCompletion() + "#", this::handleRejectedMessage);
	this.handlers.put(this.mqttProperties.getTopics().getRejection() + "#", this::handleCompletedMessage);
    }

    private void initPatterns() {
	String ackTopicRegex = this.mqttProperties.getTopics().getAck().replace(PLUS_WILDCARD, PLUS_WILDCARD_REGEX);
	this.ackPattern = Pattern.compile(ackTopicRegex);
	String completedTopicRegex = this.mqttProperties.getTopics().getCompletion().replace(PLUS_WILDCARD,
		PLUS_WILDCARD_REGEX);
	this.completedPattern = Pattern.compile(completedTopicRegex);
	String rejectedopicRegex = this.mqttProperties.getTopics().getRejection().replace(PLUS_WILDCARD,
		PLUS_WILDCARD_REGEX);
	this.rejectedPattern = Pattern.compile(rejectedopicRegex);
    }

    private void configureMapper() {
	this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	this.mapper.registerModule(new JavaTimeModule());
	this.mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	this.mapper.setSerializationInclusion(Include.NON_NULL);
    }

    private void initListener() {
	MqttCallbackExtended callback = new OperationMessagesMqttCallback();
	Set<String> topicFilters = this.handlers.keySet();
	this.mqttGateway.subscribe(topicFilters.toArray(new String[0]), callback);
    }

    @Override
    public <D extends OperationDTO> void publishOperation(D operation) {
	String topic = MqttTopicUtils.buildOperationPublishTopic(this.mqttProperties.getTopics().getPublish(),
		operation);
	try {
	    this.mqttGateway.publish(topic, this.mapper.writeValueAsString(operation));
	} catch (JsonProcessingException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    private void handleAckMessage(String topic, MqttMessage message) {
	Matcher matcher = this.ackPattern.matcher(topic);
	if (matcher.find()) {
	    Long operationId = Long.parseLong(matcher.group(1));
	    this.storeMessage(operationId, MessageType.ACK, message);
	} else {
	    LOGGER.error("Regex failed");
	}
    }

    private void handleRejectedMessage(String topic, MqttMessage message) {
	Matcher matcher = this.rejectedPattern.matcher(topic);
	if (matcher.find()) {
	    Long operationId = Long.parseLong(matcher.group(1));
	    this.storeMessage(operationId, MessageType.REJECTION, message);
	} else {
	    LOGGER.error("Regex failed");
	}
    }

    private void handleCompletedMessage(String topic, MqttMessage message) {
	Matcher matcher = this.completedPattern.matcher(topic);
	if (matcher.find()) {
	    Long operationId = Long.parseLong(matcher.group(1));
	    this.storeMessage(operationId, MessageType.COMPLETION, message);
	} else {
	    LOGGER.error("Regex failed");
	}
    }

    private void storeMessage(Long operationId, MessageType type, MqttMessage message) {
	MessageDTO m = null;
	try {
	    m = this.mapper.readValue(new String(message.getPayload(), StandardCharsets.UTF_8), MessageDTO.class);
	    m.setType(type);

	} catch (JsonProcessingException e) {
	    e.printStackTrace();
	}

	if (m != null && operationId != null) {
	    this.messageService.save(operationId, m);
	}
    }

    public class OperationMessagesMqttCallback implements MqttCallbackExtended {
	@Override
	public void connectComplete(boolean reconnect, String serverURI) {
	    if (reconnect) {
		LOGGER.info("Reconnected to broker");
		MqttServiceImpl.this.initListener();
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
	    LOGGER.info("Message arrived in Topic: {} [{}]", topic, message);
	    try {
		this.handleMessage(topic, message);
	    } catch (RuntimeException e) {
		LOGGER.error("Exception ocurred in topic: {} => {} ", topic, e.getMessage());
	    }
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
	    LOGGER.info("Delivery complete");
	}

	private void handleMessage(String topic, MqttMessage message) {
	    MqttServiceImpl.this.handlers.forEach((key, value) -> {
		if (MqttTopic.isMatched(key, topic)) {
		    value.accept(topic, message);
		}
	    });
	}
    }

}
