package Programmers;

import java.util.*;

public class Programmers42578 {
    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, List<String>> set = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            if (!set.containsKey(clothes[i][clothes[i].length - 1]))
                set.put(clothes[i][clothes[i].length - 1], new ArrayList<>());
            for (int j = 0; j < clothes[i].length - 1; j++) {
                set.get(clothes[i][clothes[i].length - 1]).add(clothes[i][j]);
            }
        }

        for (List<String> list : set.values()) {
            answer *= (list.size() + 1);
        }
        answer--;
        return answer;
    }
}
