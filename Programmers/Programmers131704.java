package Programmers;

import java.util.Arrays;
import java.util.Stack;

public class Programmers131704 {
        public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int v = 1;
        while(true){
            if(!stack.isEmpty()&&stack.peek()==order[answer]){
                stack.pop();
                answer++;
            } else if(v<=order.length){
                stack.push(v++);
            }else{
                break;
            }Arrays.stream(null).as
        }
        return answer;
    }
}
