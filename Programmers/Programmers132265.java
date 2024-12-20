package Programmers;

import java.util.HashSet;
import java.util.Set;

public class Programmers132265 {
    public int solution(int[] topping) {
        int answer = 0;
        int[] left = new int[10001];
        int[] right = new int[10001];
        Set<Integer> ls = new HashSet<>();
        Set<Integer> rs = new HashSet<>();
        for(int i = 0;i<topping.length;i++){
            right[topping[i]]++;
            rs.add(topping[i]);
        }
        for(int i = 0;i<topping.length;i++){
            if(ls.size()==rs.size())
                answer++;
            right[topping[i]]--;
            left[topping[i]]++;
            if(right[topping[i]]==0)
                rs.remove(topping[i]);
            ls.add(topping[i]);
        }
        return answer;
    }
}
