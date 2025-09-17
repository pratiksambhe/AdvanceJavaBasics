package com.example.ActionService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
// for restTemple we need this
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
