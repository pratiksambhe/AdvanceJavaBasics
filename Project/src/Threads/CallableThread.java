package Threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallableThread implements Callable<Person> {
    public Person call(){
        return new Person();
    }
}
class Person{

}
class Main2{
    public static void main(String[] args) {
        CallableThread ct=new CallableThread();
        ExecutorService es= Executors.newFixedThreadPool(10);
        es.submit(ct);
        es.shutdown();
    }
}