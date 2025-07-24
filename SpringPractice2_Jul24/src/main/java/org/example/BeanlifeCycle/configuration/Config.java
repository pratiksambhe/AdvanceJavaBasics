package org.example.BeanlifeCycle.configuration;

import org.example.BeanlifeCycle.component.Cat;
import org.example.BeanlifeCycle.component.Dog;
import org.example.BeanlifeCycle.component.Pet;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Configuration
public class Config implements InitializingBean, DisposableBean {
    @Bean(initMethod = "PetInit", destroyMethod = "PetDestroy")
    public Pet getPet(){
        return new Pet();
    }

    @Bean(name="Dog")
    public Dog getDog(){
        return new Dog();
    }
    @Bean(name="Cat")
    public Cat getCat(){
        return new Cat();
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("bean has Destroyed");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Bean has INitialized");
    }

    @PreDestroy
    public  void Destroy(){
        System.out.println("its Pre Destroy");
    }
    @PostConstruct
    public void Construct(){
        System.out.println("Its pre Construct");
    }
}
