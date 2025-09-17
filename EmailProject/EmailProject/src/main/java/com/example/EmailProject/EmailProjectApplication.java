package com.example.EmailProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class EmailProjectApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(EmailProjectApplication.class, args);
		run.getBean(EmailProjectApplication.class);
		EmailProjectApplication emailProjectApplication=new EmailProjectApplication();
	}

}
