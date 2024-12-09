package Programmers;

import java.util.StringTokenizer;

public class Programmers12939 {
    static public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while (st.hasMoreTokens()) {
            int v = Integer.parseInt(st.nextToken());
            min = Math.min(min, v);
            max = Math.max(max, v);
        }
        return min + " " + max;
    }

    public static void main(String[] args) {
        System.out.println(solution("1 2 3 4"));
        System.out.println(solution("-1 -2 -3 -4"));
        System.out.println(solution("-1 -1"));
    }
}
