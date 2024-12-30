package Programmers;

import java.util.ArrayDeque;
import java.util.Deque;

public class Programmers12909 {
        boolean solution(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(c==')'){
                if(deque.isEmpty())
                    return false;
                deque.pop();
            }else{
                deque.add(c);
            }
        }
        if(deque.size()>0)
            return false;
        return true;
    }
}
