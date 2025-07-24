package org.example;

import org.example.components.RBI;
import org.example.repo.Config;
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
        ApplicationContext ap= new AnnotationConfigApplicationContext(Config.class);
        RBI r=ap.getBean(RBI.class);
        r.BankAukad();
    }
}
