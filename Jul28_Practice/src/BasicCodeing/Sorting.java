package BasicCodeing;

public class Sorting {
    public void sort(int[] a){
        for(int i=0;i<a.length;i++){
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
    public static void main(String[] args) {
         int[]a={12,1,323,22,12,3};
      Sorting s=new Sorting();
//      s.sort(a);
    int b=10;
    int c=20;
    b=b+c;
    c=b-c;
    b=b-c;
        System.out.println(b+" "+c);
    }}


