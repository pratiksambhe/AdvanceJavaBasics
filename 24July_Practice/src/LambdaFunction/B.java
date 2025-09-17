package LambdaFunction;

public class B {
    public static void main(String[] args) {

 A a2=new A(){
     public void m1(int a,int b){
         System.out.println(a+b);
     }
 };


    A a=(int c,int b)->{
        System.out.println(c+b);
    };
    a.m1(12,13);
    }
}
