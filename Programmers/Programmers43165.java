package Programmers;

public class Programmers43165 {
    class Solution {
        static int answer;
        static int target;
        static int[] numbers;
        static void dfs(int i, int v){
            if(i == numbers.length){
                if(v == target)
                    answer++;
                return;
            }
            dfs(i+1,v+numbers[i]);
            dfs(i+1,v-numbers[i]);
        }
        public int solution(int[] numbers, int target) {
            this.target = target;
            this.numbers = numbers;
            answer = 0;
            dfs(0,0);
            return answer;
        }
    }
}
