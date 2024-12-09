package Programmers;

public class Programmers82612 {
    static public long solution(int price, int money, int count) {
        long answer = 0;
        for (int i = 1; i <= count; i++)
            answer += price * i;
        return money - answer > 0 ? 0 : Math.abs(money - answer);
    }

    public static void main(String[] args) {
        System.out.println(solution(3, 20, 4)); // 10
    }
}
