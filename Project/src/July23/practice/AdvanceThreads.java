package July23.practice;

import java.util.concurrent.*;

public class AdvanceThreads implements Callable<String>  {
   public String call(){
       return Thread.currentThread().getName();
   }
   public void m1(int a,int b){
       System.out.println("m1");
   }
}
class Main5{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        AdvanceThreads at=new AdvanceThreads();

        ExecutorService es= Executors.newSingleThreadExecutor();
        ExecutorService es2=Executors.newFixedThreadPool(10);
        ExecutorService es3=Executors.newCachedThreadPool();
        ScheduledExecutorService es4=Executors.newScheduledThreadPool(10);
//        Runnable task=()->{
//            System.out.println(Thread.currentThread().getName());
//        };
//        es4.scheduleAtFixedRate(task,1,2, TimeUnit.SECONDS);

            Future<String> f= es3.submit(at);
        for(int i=0;i<10;i++){
            Thread.sleep(1000);
            System.out.println(f.get());
        System.out.println(f.isCancelled()+" "+f.isDone()+" ");
        f.cancel(true);
        }
        System.out.println(f.isCancelled()+" "+f.isDone()+" ");
        es4.shutdown();
    }
}