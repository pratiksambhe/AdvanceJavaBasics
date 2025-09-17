package July23.practice;

public class UpcastingDowncasting {

}
class A1{
    public void m1(){
        System.out.println("m1");
    }
}
class A2 extends A1{
    public void m2(){
        System.out.println("m2");
    }
}
class Main2{
    public static void main(String[] args) {
        A1 a=new A2();//upcasting
//        OR
        A2 a2=new A2();
        A1 a1=a2;


        //Downcasting
        A1 a3=new A1();
        A2 a4=(A2)a3;
    }
}