package July23.practice;
@java.lang.FunctionalInterface
public interface FunctionalInterface {
    public  abstract void  m1(int a,int b);
}
class Main4{//lambda Expression
    public static void main(String[] args) {
        FunctionalInterface f=(a,b)->{
            System.out.println("its functional with lambda "+(a+b));
        };
    }
        }
class Main3{ //Functional Interface
    public static void main(String[] args) {
        FunctionalInterface f=new FunctionalInterface(){
          @Override
          public void m1(int a,int b){
              System.out.println("its functional interface");
          }
        };
    }

}
