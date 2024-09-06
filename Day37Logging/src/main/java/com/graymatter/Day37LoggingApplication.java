package com.graymatter;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Day37LoggingApplication {
	
	Logger logger=LoggerFactory.getILoggerFactory()

	public static void main(String[] args) {
		SpringApplication.run(Day37LoggingApplication.class, args);
	}

}
