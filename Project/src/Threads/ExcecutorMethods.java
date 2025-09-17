package Threads;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExcecutorMethods {
    public static void main(String[] args) {
        Runnable r=()->{for(int i=0;i<100;i++){
            System.out.println(Thread.currentThread());
        }};
        ScheduledExecutorService se= Executors.newScheduledThreadPool(5);
//        se.schedule(r,3, TimeUnit.SECONDS);
        for(int i=0;i<5;i++){

        se.scheduleAtFixedRate(r,2,3, TimeUnit.SECONDS);
        }
//        se.shutdown();
    }
}
