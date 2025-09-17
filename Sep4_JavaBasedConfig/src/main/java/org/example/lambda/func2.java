package org.example.lambda;

public class func2 {
    public static void main(String[] args) {

        func a = new func() {
            public void sum(int a, int b) {
                System.out.println(a + b);
            }
        };

        a.sum(1,2);

        func b=(int d,int c)->{
            System.out.println(d*c);
        };

        b.sum(5,6);
    }
}
