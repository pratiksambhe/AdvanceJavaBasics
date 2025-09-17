package Threads;

import com.sun.xml.internal.bind.v2.model.annotation.RuntimeAnnotationReader;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallableAdvance2 implements Callable<Integer> {
    public Integer call(){
        this.m11();
        try {
            Thread.sleep(1000);
        }catch(InterruptedException e) {

        }return 0;
        }

    public void m11(){
        for(int i=0;i<1000000000;i++){
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }

}
class Main3{
    public static void main(String[] args) {
        Person p=new Person();
        CallableAdvance2 cd=new CallableAdvance2();
        ExecutorService es= Executors.newFixedThreadPool(10);
        for(int i=0;i<10;i++){
            es.submit(new person());

        }
        es.shutdown();
    }
}
class person implements Runnable {
public void run(){

}
}
