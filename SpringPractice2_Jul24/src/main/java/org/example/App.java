package org.example;

import org.example.BeanlifeCycle.component.Pet;
import org.example.annotationbased.byxml.components.Capacity;
import org.example.xmlbased.components.Vehical;
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

    //XmlBased
//        ApplicationContext ac=new ClassPathXmlApplicationContext("SpringXmlConfig.xml");
//        Vehical v=ac.getBean(Vehical.class);
//        v.engineType();


        //JavaBased
//        ApplicationContext ac=new AnnotationConfigApplicationContext(Config.class);
//        Pet p=ac.getBean(Pet.class);
//        p.petType();

        //Annotaionbased with Config Class

//        ApplicationContext ac=new AnnotationConfigApplicationContext(Config.class);
//        Capacity c=ac.getBean(Capacity.class);
//        c.personCarry();


        //Annotaionbased with Config.xml file
//        ApplicationContext ac=new ClassPathXmlApplicationContext("Config.xml");
//        Capacity c=ac.getBean(Capacity.class);
//        c.personCarry();

//        //BeanLifeCycle
//        AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(Config.class);
//        Pet p=ac.getBean(Pet.class);
//        p.petType();
//        ac.close();
    }
}
