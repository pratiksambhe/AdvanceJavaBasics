package Threads;

import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableThread implements Runnable{
        TreeSet<String> t=new TreeSet<>();
    public void run(){
        this.m1();
        try{
        Thread.sleep(1000);
    } catch (InterruptedException e) {
            System.out.println("Exception");
        }
    }
    public void m2(){
        t.forEach(System.out::println);
    }
    public void m1(){
        for(int i=0;i<100;i++){
        String s= String.valueOf(Thread.currentThread());
            t.add(s);
        }this.m2();
    }
}
 class Main{
     public static void main(String[] args) {
         RunnableThread rt=new RunnableThread();

         ExecutorService es= Executors.newFixedThreadPool(10);
         es.submit(rt);
         es.shutdown();

     }
}
