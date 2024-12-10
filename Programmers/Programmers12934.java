package Programmers;

public class Programmers12934 {
    static public long solution(long n) {
        double v = Math.sqrt(n);
        long num = 0;
        if (Math.round(v) == v)
            num = Math.round(v);
        if (num == 0)
            return -1;
        return (num + 1) * (num + 1);
    }

    public static void main(String[] args) {
        System.out.println(solution(121));
        System.out.println(solution(3));
        System.out.println(solution(50000000000000L));
    }
}
