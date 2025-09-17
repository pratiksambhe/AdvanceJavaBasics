package org.example;

import org.example.java.Config;
import org.example.java.Vehicle;
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
//        Vehicle vehicle = ap.getBean(Vehicle.class);
//        vehicle.engineInfo();

        AnnotationConfigApplicationContext apn=new AnnotationConfigApplicationContext(Config.class);
        Vehicle bean = apn.getBean(Vehicle.class);
        bean.getEngine();
        apn.close();

//        ApplicationContext apn=new AnnotationConfigApplicationContext(Config.class);
//        Vehicle bean = apn.getBean(Vehicle.class);
//        bean.getEngine();


//   ApplicationContext applicationContext=new ClassPathXmlApplicationContext("config.xml");
//        Vehicle bean = applicationContext.getBean(Vehicle.class);
//        bean.getEngine();
    }
}
