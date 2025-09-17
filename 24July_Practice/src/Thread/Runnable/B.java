package Thread.Runnable;

public class B implements Runnable{
public void run(){
    for(int i=0;i<10;i++){
        try {
            Thread.sleep(1000);
        }catch(InterruptedException e) {
            System.out.println(e);}System.out.println(i+" "+Thread.currentThread().getName());

    }
}

    public static void main(String[] args) {
        B b=new B();
        Thread t=new Thread(b);
     t.start();
    }
}
