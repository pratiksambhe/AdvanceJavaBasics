package com.example.AUg5_SpringProject.codeingQue;

public class ReverseString {

    public static void main(String[] args) {
        String input = "shreyash";
        ReverseString reverseString = new ReverseString();
        String reverse = reverseString.reverseString(input);
        System.out.println(reverse);

    }

    private String reverseString(String input) {
        String rev = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            rev += input.charAt(i);

        }
        return rev;
    }


}
