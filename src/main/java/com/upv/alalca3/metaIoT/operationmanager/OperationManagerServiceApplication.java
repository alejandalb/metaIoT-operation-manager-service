package com.upv.alalca3.metaIoT.operationmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJpaRepositories
@EnableJpaAuditing
@EnableScheduling
public class OperationManagerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OperationManagerServiceApplication.class, args);
	}

}
