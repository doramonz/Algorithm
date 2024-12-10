package Programmers;

public class Programmers86051 {
    public int solution(int[] numbers) {
        int answer = 0;
        boolean[] arr = new boolean[10];
        for(int i : numbers)
            arr[i] = true;
        for(int i = 0;i<10;i++)
            if(!arr[i])
                answer+=i;
        return answer;
    }
}
