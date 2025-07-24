package org.example.configuration;

import org.example.components.Screen;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.example.components")
public class Config {

    @Bean
    public Screen getScreen()
    {
        return new Screen();
    }

}
