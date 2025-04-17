package com.thejoa.boot3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Boot003Application {

	public static void main(String[] args) {
		SpringApplication.run(Boot003Application.class, args);
	}

}
