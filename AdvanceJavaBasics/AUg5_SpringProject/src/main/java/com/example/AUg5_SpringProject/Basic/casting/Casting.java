package com.example.AUg5_SpringProject.Basic.casting;

public class Casting {
    public static void main(String[] args) {
        //implicit/wideing
        byte a = 1;
        short b = a;
        char c = 'c';
        int d = c;
        long e = d;
        float f = e;
        double g = f;

        //explicit/narrowing
        double a1 = 123.00;
        float b1 = (float) a1;
        long c1 = (int) b1;
//        like wise
    }
}
