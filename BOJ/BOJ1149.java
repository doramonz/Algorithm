package BOJ;

import java.util.Scanner;

public class BOJ1149 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[][] d = new int[n][3];
        int[][] v = new int[n][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++)
                d[i][j] = scanner.nextInt();
        }

        scanner.close();

        v[0][0] = d[0][0];
        v[0][1] = d[0][1];
        v[0][2] = d[0][2];

        for (int i = 1; i < n; i++) {
            if (v[i - 1][1] < v[i - 1][2]) {
                v[i][0] = d[i][0] + v[i - 1][1];
            } else {
                v[i][0] = d[i][0] + v[i - 1][2];
            }
            if (v[i - 1][0] < v[i - 1][2]) {
                v[i][1] = d[i][1] + v[i - 1][0];
            } else {
                v[i][1] = d[i][1] + v[i - 1][2];
            }
            if (v[i - 1][0] < v[i - 1][1]) {
                v[i][2] = d[i][2] + v[i - 1][0];
            } else {
                v[i][2] = d[i][2] + v[i - 1][1];
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (v[n - 1][i] < min)
                min = v[n - 1][i];
        }
        System.out.println(min);
    }
}
