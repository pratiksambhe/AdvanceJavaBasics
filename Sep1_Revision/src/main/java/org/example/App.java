package org.example;

import org.example.annotationBased.config.Config;
import org.example.annotationBased.entity.Org;
import org.example.entity.Vehicle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(Config.class);
//        Vehicle s=applicationContext.getBean(Vehicle.class);
//        s.engineInfo();

        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(Config.class);
        Org org=applicationContext.getBean(Org.class);
        org.info();
    }
}
