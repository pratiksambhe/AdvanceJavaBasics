import java.util.Arrays;

public class Practice {
    public void minMax(int a[]) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
            if (a[i] > max) {
                max = a[i];
            }
        }
        System.out.println(min + " " + max);
    }

    public void pallindrome(String a) {
        int i = 0;
        int j = a.length() - 1;
        boolean p = true;
        while (i < j) {
            if (a.charAt(i) != a.charAt(j)) {
                p = false;
            }
            i++;
            j--;
        }
        if (p) {
            System.out.println("pallindrome");
        } else {
            System.out.println("non pallindrome");
        }
    }

    public void reverseInteger(Integer a) {
        int sum = 0;
        while (a != 0) {
            sum = sum * 10 + a % 10;
            a /= 10;
        }
        System.out.println(sum);
    }

    public void rotateArray(int[] a, int k) {
        int b[] = new int[k];
        int x = 0;
        for (int i = b.length - 1; i >= 0; i--) {

            b[i] = a[a.length - 1 - x];
            x++;
            System.out.println(b[i]);
        }
        for (int i = a.length - 1; i >= k; i--) {
            a[i] = a[i - k];
        }
        for (int i = 0; i < k; i++) {
            a[i] = b[i];
        }

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public void anagramCheck(int a[],int b[]){
        Arrays.sort(a);
        Arrays.sort(b);
        if(Arrays.equals(a,b)){
            System.out.println("anagram");
        }else{
            System.out.println("not anagram");
        }
    }

    public static void main(String[] args) {
        Practice practice = new Practice();
        int a[] = {2, 22, 1, 332, 21, 331, 2};
        int c[]={2, 2, 22, 1, 332, 21, 331};
        String b = "ancna";
//        practice.minMax(a);
//        practice.pallindrome(b);
//        practice.reverseInteger(123);
//        practice.rotateArray(a, 5);
        practice.anagramCheck(a,c);
    }
}
