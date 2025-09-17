package Thread;

public class A  extends Thread{
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println(i);

        try{
        Thread.sleep(10000);}catch (InterruptedException e){
            System.out.println(e);
        }
        }

    }

    public static void main(String[] args) {
        A a=new A();
        a.start();

    }
}
