package com.idrbt.lab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
@SpringBootApplication
public class MobileCommunicationApplication {

	public static void main(String[] args) {

		final Logger logger = LoggerFactory.getLogger(MobileCommunicationApplication.class);
		logger.info("Mobile Communication Application service started");
		SpringApplication.run(MobileCommunicationApplication.class, args);
	}

}
