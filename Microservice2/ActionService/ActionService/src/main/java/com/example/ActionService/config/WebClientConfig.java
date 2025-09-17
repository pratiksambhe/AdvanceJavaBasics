package com.example.ActionService.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

//it is for webClient
@Configuration
public class WebClientConfig {

    @Bean
    @LoadBalanced   // allows using Eureka service name instead of host:port
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }
}
