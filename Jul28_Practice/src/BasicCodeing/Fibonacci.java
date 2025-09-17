package BasicCodeing;

public class Fibonacci {
    public void fibo(int a){
        if(a<0){
            System.out.println("Enter the valid value");
        } else if (a==0) {
            System.out.println(0);
        } else if (a==1) {
            System.out.println("0 1");
        }else{
            System.out.print("0 1");
            int a1=0;
            int a2=1;
            int c;
            for(int i=1;i<a;i++){
                c=a1+a2;
                System.out.print(" "+c);
                a1=a2;
                a2=c;
            }
        }
    }

    public static void main(String[] args) {
        Fibonacci f=new Fibonacci();
        f.fibo(15);
    }
}
