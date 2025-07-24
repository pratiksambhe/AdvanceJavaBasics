package org.example.annotationbased.byclassconfig.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("org.example.annotationbased.byclassconfig.components")
public class Config {
}
