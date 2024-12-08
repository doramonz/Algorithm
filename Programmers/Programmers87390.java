package Programmers;

import java.util.Arrays;

public class Programmers87390 {
    static public int[] solution(int n, long left, long right) {
        int size = (int) (right - left) + 1;
        int[] answer = new int[size];
        int index = 0;
        while (left <= right) {
            answer[index++] = (int) Math.max(left / n, left % n)+1;
            left++;
        }
        return answer;
    }

    // 1234223433344444
    public static void main(String[] args) {
        Arrays.stream(solution(3, 2, 5)).forEach(x -> System.out.print(x));
        System.out.println();
        Arrays.stream(solution(4, 7, 14)).forEach(x -> System.out.print(x));
        System.out.println();
        Arrays.stream(solution(4, 4, 6)).forEach(x -> System.out.print(x));
        System.out.println();

        solution(1000000, 0, 1000000000L);
    }
}
