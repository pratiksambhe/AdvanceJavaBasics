package org.example.javabased.config;

import org.example.javabased.entity.Diesel;
import org.example.javabased.entity.Petrol;
import org.example.javabased.entity.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Diesel getDiesel() {
        return new Diesel();
    }

    @Bean
    public Petrol getPetrol() {
        return new Petrol();
    }

    @Bean
    public Vehicle getVehicle() {
        return new Vehicle();
    }

}
