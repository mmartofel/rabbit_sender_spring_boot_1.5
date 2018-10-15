package com.example.rabbit_sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling

public class RabbitSenderApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(RabbitSenderApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RabbitSenderApplication.class, args);
	}

}
