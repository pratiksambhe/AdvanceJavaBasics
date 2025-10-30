package com.example.AUg5_SpringProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
@EnableScheduling
@SpringBootApplication

public class AUg5SpringProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AUg5SpringProjectApplication.class, args);
	}

}
