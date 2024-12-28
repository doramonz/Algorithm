package Programmers;

import java.util.HashSet;
import java.util.Set;

public class Programmers42839 {
        static int answer;
    static Set<Integer> set = new HashSet<>();
    static boolean[] used;
    static char[] number;
    static StringBuilder sb = new StringBuilder();
    static boolean isPrime(int v){
        if(v==0 || v==1)
            return false;
        if(v==2||v==3)
            return true;
        for(int i = 2;i*i<=v;i++){
            if(v%i==0)
                return false;
        }
        return true;
    }
    static void recur(){
        if(sb.length()>0&&!set.contains(Integer.parseInt(sb.toString()))){
            set.add(Integer.parseInt(sb.toString()));
            if(isPrime(Integer.parseInt(sb.toString())))
                answer++;
        }
        for(int i = 0;i<number.length;i++){
            if(used[i])
                continue;
            used[i] = true;
            sb.append(number[i]);
            recur();
            sb.deleteCharAt(sb.length()-1);
            used[i] = false;
        }
    }
    public int solution(String numbers) {
        answer = 0;
        used = new boolean[numbers.length()];
        number = numbers.toCharArray();
        recur();
        return answer;
    }
}
