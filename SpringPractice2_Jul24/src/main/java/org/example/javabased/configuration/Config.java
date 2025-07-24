package org.example.javabased.configuration;

import org.example.javabased.components.Cat;
import org.example.javabased.components.Dog;
import org.example.javabased.components.Pet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("org.example.javabased.components")
public class Config {
@Bean
    public Pet getPet(){
    return new Pet();
}
@Bean
    public Dog getDog(){
    return new Dog();
}
@Bean(name="ThisgetCat")
    public Cat getCat(){
    return new Cat();
}

}
