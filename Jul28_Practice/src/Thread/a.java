package Thread;

import java.util.concurrent.*;

public class a implements Callable<Person> {
@Override
    public Person call(){
    System.out.println("xyz"+Thread.currentThread().getName());
    Person p=new Person("Pratik");
    return p;
}

    public static void main(String[] args) throws ExecutionException, InterruptedException {
    a A=new a();
    ExecutorService es= Executors.newCachedThreadPool();
     Runnable r=()->{
         System.out.println(0);
     } ;
        ScheduledExecutorService se=Executors.newScheduledThreadPool(10);
//        se.scheduleAtFixedRate(r,1,2, TimeUnit.SECONDS);
    for(int i=0;i<10;i++){
    Future<Person> p=es.submit(A);
        System.out.println(p.get());
    }
    es.shutdown();

    }
}
class Person{
 Person(String name){
     System.out.println(name);
 }
}
