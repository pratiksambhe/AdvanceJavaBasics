package July23.practice;

public class SimpleThreads extends Thread{
    @Override
    public void run(){
        try {
            Thread.sleep(2000);
        }
        catch(InterruptedException e){
            System.out.println(e);
        }
        this.m1();
        }

        public void m1(){
            System.out.println(Thread.currentThread().getName());
        }

    public static void main(String[] args) {
        SimpleThreads s=new SimpleThreads();
        s.start();
        SimpleThreads s1=new SimpleThreads();
        s1.start();

        for(int i=0;i<10;i++){
            s.m1();
            s1.m1();
        }
    }
}
