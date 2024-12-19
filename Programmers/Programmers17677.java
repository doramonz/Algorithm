package Programmers;

import java.util.HashMap;
import java.util.Map;

public class Programmers17677 {
    public int solution(String str1, String str2) {
        Map<String,Integer> set1 = new HashMap<>();
        Map<String,Integer> set2 = new HashMap<>();
        for(int i = 0;i<str1.length()-1;i++){
            if(((str1.charAt(i)>='a'&&str1.charAt(i)<='z')||(str1.charAt(i)>='A'&&str1.charAt(i)<='Z'))&&((str1.charAt(i+1)>='a'&&str1.charAt(i+1)<='z')||(str1.charAt(i+1)>='A'&&str1.charAt(i+1)<='Z'))){
                set1.put(str1.substring(i,i+2).toUpperCase(),set1.getOrDefault(str1.substring(i,i+2).toUpperCase(),0)+1);
            }
        }
        for(int i = 0;i<str2.length()-1;i++){
            if(((str2.charAt(i)>='a'&&str2.charAt(i)<='z')||(str2.charAt(i)>='A'&&str2.charAt(i)<='Z'))&&((str2.charAt(i+1)>='a'&&str2.charAt(i+1)<='z')||(str2.charAt(i+1)>='A'&&str2.charAt(i+1)<='Z'))){
                set2.put(str2.substring(i,i+2).toUpperCase(),set2.getOrDefault(str2.substring(i,i+2).toUpperCase(),0)+1);
            }
        }
        double cross = 0;
        double union = 0;
        for(String k : set1.keySet()){
            if(set2.containsKey(k)){
                cross+=Math.min(set2.get(k),set1.get(k));
                union-=Math.min(set1.get(k),set2.get(k));
            }
            union+=set1.get(k);
        }
        for(String k : set2.keySet()){
            union+=set2.get(k);
        }
        if(union==0)
            return 65536;
        return (int)(cross/union*65536);
    }
}
