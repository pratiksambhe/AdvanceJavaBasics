package com.example.AUg5_SpringProject.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Swagger {
    @Bean
    public OpenAPI swag(){
        return new OpenAPI().info(new Info().title("Person").description("It's Person Swagger").version("5.5"));
    }
}
