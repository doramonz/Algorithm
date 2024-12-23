package Programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Programmers17684 {
        public int[] solution(String msg) {
        List<Integer> result = new ArrayList<>();
        int index = 1;
        Map<String, Integer> dic = new HashMap<>();
        for(char i = 'A';i<='Z';i++)
            dic.put(String.valueOf(i),index++);
        int i = 0;
        while(i<msg.length()){
            int j = i + 1;
            while(j<=msg.length()&&dic.containsKey(msg.substring(i,j)))
                j++;
            result.add(dic.get(msg.substring(i,j-1)));
            if(j<=msg.length())
                dic.put(msg.substring(i,j),index++);
            i = j-1;
            
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
