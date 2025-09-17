package org.example;

import org.example.javaBased.component.Vehical;
import org.example.javaBased.configuration.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        ApplicationContext ap=new AnnotationConfigApplicationContext(Config.class);
//        org.example.javaBased.component.Vehical vehical=ap.getBean(Vehical.class);
//        vehical.engineName();

//        ApplicationContext ap=new ClassPathXmlApplicationContext("Config1.xml");
//        org.example.xml.component.Vehical v=ap.getBean(Vehical.class);
//        v.getName();

        AnnotationConfigApplicationContext ap=new AnnotationConfigApplicationContext(Config.class);
        org.example.javaBased.component.Vehical v=ap.getBean(Vehical.class);
        v.engineName();
        ap.close();

            }
}
