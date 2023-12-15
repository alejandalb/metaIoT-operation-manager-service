package com.upv.alalca3.metaIoT.operationmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.upv.alalca3.metaIoT.operationmanager.service.IMqttService;

@SpringBootApplication
public class OperationManagerServiceApplication implements ApplicationRunner {
	@Autowired
	private IMqttService mqttService;

	public static void main(String[] args) {
		SpringApplication.run(OperationManagerServiceApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		this.launchMqttListenerServices();
	}

	private void launchMqttListenerServices() {
		this.mqttService.subscribe();
	}

}
