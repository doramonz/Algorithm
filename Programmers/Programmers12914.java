package Programmers;

public class Programmers12914 {
    static long[] arr = new long[2000];

    static public long solution(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        if (arr[n] != 0)
            return arr[n];
        return arr[n] = (solution(n-2)+solution(n-1))%1234567;
    }

    public static void main(String[] args) {
        System.out.println(solution(4) == 5);
        System.out.println(solution(3) == 3);
    }
}
