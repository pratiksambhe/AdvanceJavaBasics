package casting;

public class B implements A{
}
class Main {
    public static void main(String[] args){
        A a=new B();//Upcasting

        B b=(B) a;//downcasting


    }
}