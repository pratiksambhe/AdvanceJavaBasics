package com.example.AUg5_SpringProject.codeingQue;

public class NonRepeatingChar {
    public static void main(String[] args) {
        String input="shreyash";
        for(int i=0;i<input.length();i++){
            int k=0;
            for(int j=0;j<input.length();j++){
                if(input.charAt(i)==input.charAt(j)){
                    k++;
                }
            }
            if(k==1){
                System.out.println(input.charAt(i));
                break;
            }
        }
    }
}
