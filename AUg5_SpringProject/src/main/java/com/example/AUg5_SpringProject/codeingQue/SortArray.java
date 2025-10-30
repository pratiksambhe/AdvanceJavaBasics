package com.example.AUg5_SpringProject.codeingQue;

public class SortArray {
    public static void main(String[] args) {
        int a[]={1,2,1,343,1,3,423,12432,6};
        for(int i=0;i< a.length;i++){
            for(int j=0;j<a.length;j++){
                if(a[i]<a[j]){
                    int k=a[i];
                    a[i]=a[j];
                    a[j]=k;
                }
            }
        }
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
