package Programmers;

import java.util.ArrayList;
import java.util.List;

public class Programmers12906 {
        public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        for(int i : arr){
            if(list.get(list.size()-1)==i)
                continue;
            list.add(i);
        }
        list.remove(0);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
