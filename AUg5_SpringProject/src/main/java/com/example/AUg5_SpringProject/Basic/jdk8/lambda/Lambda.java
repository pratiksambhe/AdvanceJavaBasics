package com.example.AUg5_SpringProject.Basic.jdk8.lambda;

public class Lambda {
//    Lambda l=(int a,int b)->{
//        System.out.println(a+b);
//    };



    public static void main(String[] args) {
        A l=new A(){
            public void add(int a,int b){
                System.out.println(a+b);
            }
        }   ;
        l.add(2,3);
    }

    A d=(int a,int b)->{

        System.out.println(a*b);
    };


}
