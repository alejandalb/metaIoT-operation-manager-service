package com.upv.alalca3.metaIoT.operationmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.upv.alalca3.metaIoT.operationmanager.service.MqttService;

@SpringBootApplication
@EnableJpaRepositories
@EnableJpaAuditing
@EnableScheduling
public class OperationManagerServiceApplication implements ApplicationRunner {
	@Autowired
	private MqttService mqttService;

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
