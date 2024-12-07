package Programmers;

public class Programmers11926 {
    static boolean solution(String s) {
        int[] arr = new int[200];
        for(char c : s.toCharArray())
            arr[c]++;

        return arr['p']==arr['y'];
    }

    public static void main(String[] args) {
        System.out.println(solution("pPoooyY"));
        System.out.println(solution("Pyy"));
    }
}
