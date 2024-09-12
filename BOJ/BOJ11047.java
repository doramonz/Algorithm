package BOJ;

import java.util.Scanner;

public class BOJ11047 {
    private static int minCoinCal(int[] value, int money) {
        int times = 0;
        for (int i = value.length - 1; i >= 0; i--) {
            times += money / value[i];
            money %= value[i];
        }
        return times;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a, b;
        a = scanner.nextInt();
        b = scanner.nextInt();
        int[] arr = new int[a];
        for (int i = 0; i < a; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();
        System.out.println(minCoinCal(arr, b));
    }
}
