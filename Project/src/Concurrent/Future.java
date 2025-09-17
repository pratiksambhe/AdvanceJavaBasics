package Concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Future {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService es= Executors.newFixedThreadPool(10);
        java.util.concurrent.Future<Integer> s=es.submit(()->{
            Thread.sleep(10000);
            return 100;
        });
        s.cancel(true);
        System.out.println(s.isDone()+" "+s.isCancelled());
    }
}
