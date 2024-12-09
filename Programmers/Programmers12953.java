package Programmers;

public class Programmers12953 {
    static int gcd(int a, int b) {
        while (a % b != 0) {
            a = a % b;
            int t = a;
            a = b;
            b = t;
        }
        return b;
    }

    static public int solution(int[] arr) {
        int answer = arr[0];
        if (arr.length == 1)
            return answer;
        for (int i = 1; i < arr.length; i++) {
            answer = answer * arr[i] / gcd(answer, arr[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] { 2, 6, 8, 14 }));
        System.out.println(solution(new int[] { 1, 2, 3 }));
    }
}
