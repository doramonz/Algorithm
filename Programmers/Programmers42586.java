package Programmers;

import java.util.*;

public class Programmers42586 {

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        int[] count = new int[progresses.length];
        for(int i = 0;i<progresses.length;i++){
            count[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }
        int max = count[0];
        int c = 0;
        for(int i : count){
            if(i<=max){
                c++;
            }else{
                result.add(c);
                c = 1;
                max = i;
            }
        }
        
        result.add(c);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
