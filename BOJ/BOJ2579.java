package BOJ;

import java.util.Scanner;

public class BOJ2579 {
    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        scanner.close();

        int[][] d = new int[n][2];

        d[0][0] = arr[0];
        d[0][1] = arr[0];
        if (n > 1) {
            d[1][0] = arr[1];
            d[1][1] = arr[1] + d[0][0];
        }

        for (int i = 2; i < n; i++) {
            if (d[i - 2][0] > d[i - 2][1]) {
                d[i][0] = d[i - 2][0] + arr[i];
            } else {
                d[i][0] = d[i - 2][1] + arr[i];
            }
            d[i][1] = d[i - 1][0] + arr[i];
        }

        if (d[n - 1][0] > d[n - 1][1]) {
            System.out.println(d[n - 1][0]);
        } else {
            System.out.println(d[n - 1][1]);
        }
    }
}
