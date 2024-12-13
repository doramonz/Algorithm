package Programmers;

import java.util.*;

public class Programmers17680 {

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Deque<String> deque = new ArrayDeque<>(cacheSize);
        for (String s : cities) {
            s = s.toLowerCase();
            if (deque.contains(s)) {
                answer += 1;
                deque.remove(s);
                deque.add(s);
            } else {
                answer += 5;
                deque.add(s);
                if (deque.size() > cacheSize)
                    deque.poll();
            }
        }
        return answer;
    }
}