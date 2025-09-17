package Casting;

public class B extends A {
}
class Main{
    public static void main(String[] args) {
        A a=new B();
        B b=new B();
        A a2=b;

        B b2=(B) a;
    }
}
