package BasicCodeing;

public class ShiftArray {
public static void shiftArray(int a[],int k){
    int l;
    int j;

        l=a[a.length-1];
        j=a[a.length-2];
    for(int i= a.length-1;i>=k;i-=k){
    a[i]=a[i-2];
    a[i-1]=a[i-3];
    }
    a[0]=j;
    a[1]=l;
    for(int i=0;i<a.length;i++){
        System.out.println(a[i]);
    }
}
    public static void main(String[] args) {
        int []a={12,23,3,123,231,15};
       ShiftArray.shiftArray(a,2);
    }
}
