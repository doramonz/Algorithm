package Programmers;

import java.util.Stack;

public class Programmers153539 {
        public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<int[]> stack = new Stack<>();
        for(int i = 0;i<numbers.length;i++){
            if(stack.isEmpty()){
                stack.add(new int[]{i,numbers[i]});
            }else{
                while(!stack.isEmpty()&&stack.peek()[1]<numbers[i]){
                    answer[stack.pop()[0]]=numbers[i];
                }
                stack.add(new int[]{i,numbers[i]});
            }
        }
        while(!stack.isEmpty()){
            answer[stack.pop()[0]]=-1;
        }
        return answer;
    }
}
