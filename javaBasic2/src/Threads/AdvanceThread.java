package Threads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AdvanceThread extends Thread {
    public void run(){
        this.m1();

    }
    public void m1(){
        for(int i=0;i<10;i++){
            System.out.println(i);
            System.out.println(Thread.currentThread());
        }
    }

    public static void main(String[] args) {
AdvanceThread a=new AdvanceThread();
        a.start();

    }
}
