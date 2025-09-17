package lambdaAndFunctionalInterface;

public class B {
    public static void main(String[] args) {
        A a=new A(){
          @Override
          public void add(int a,int b){
              System.out.println(a+b);
          }
        };

        A a2=(b,c)->{
            System.out.println(c-b);
        };
        a2.add(12,13);
        a.add(12,13);
    }
}
