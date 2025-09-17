package Thread.Advance;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.util.concurrent.*;

public class Sigle implements Callable<Person> {
public Person call() {
    for (int i = 1; i < 10; i++) {
        System.out.println("Ok" + Thread.currentThread().getName());
//        System.out.println();
        try {
            Thread.sleep(61000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
        return new Person();
}}
class main{
    public static void main(String[] args) {
        Sigle s=new Sigle();
//        ExecutorService es= Executors.newSingleThreadExecutor();
//        ExecutorService es=Executors.newFixedThreadPool(10);
//        ExecutorService es=Executors.newCachedThreadPool();
        Runnable r=()->{
            System.out.println(Thread.currentThread().getName());
        };
        ScheduledExecutorService es=Executors.newSingleThreadScheduledExecutor();
        es.scheduleAtFixedRate(r,2,2, TimeUnit.SECONDS);
        for(int i=0;i<10;i++) {
        es.submit(s);

          ;}
        es.shutdown();
    }
}
class Person{
    Person(){
        System.out.println("Person1");
    }
}