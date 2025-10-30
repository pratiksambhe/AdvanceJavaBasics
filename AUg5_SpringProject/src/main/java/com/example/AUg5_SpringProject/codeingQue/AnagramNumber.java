package com.example.AUg5_SpringProject.codeingQue;

public class AnagramNumber {
    public static void main(String[] args) {
    int num=15;
        int a=num;
        int b=num;
        int sum=0;
        int i=0;
        while(a!=0){
            i++;
            a/=10;
        }
        while(b!=0){
            sum=sum+(int)Math.pow(b%10,i);
            b/=10;
                    }
        System.out.println(sum);
    if(sum==num){

        System.out.println("Armstrong");
    }
    }
}
