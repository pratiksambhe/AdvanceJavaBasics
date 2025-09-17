package BasicCodeing;

import java.util.ArrayList;
import java.util.Collections;

public class Anagram {
    public static void main(String[] args) {
        String a="uhh";
        String b="okh";
        boolean isAnagram=true;
        if(a.length()!=b.length()){
            isAnagram=false;
        }else{
            ArrayList<Character> l=new ArrayList<>();
            ArrayList<Character> l2=new ArrayList<>();
            for(int i=0;i<a.length();i++){
                l.add(a.charAt(i));
                l2.add(b.charAt(i));
                Collections.sort(l);
                Collections.sort(l2);
                if(!l.equals(l2)){
                    isAnagram=false;
                }
            }
        }
        if(isAnagram)
    }

}
