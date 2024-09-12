package BOJ;

import java.util.Scanner;

public class BOJ1463 {

    public static void main(String[] args) {
        int[] routes = new int[1000001];
        routes[1] = 0;
        routes[2] = 1;
        routes[3] = 1;

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        for (int i = 4; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            if (i % 3 == 0 && routes[i / 3] < min) {
                min = routes[i / 3];
            }
            if (i % 2 == 0 && routes[i / 2] < min) {
                min = routes[i / 2];
            }
            if (routes[i - 1] < min) {
                min = routes[i - 1];
            }
            routes[i] = min + 1;
        }

        System.out.println(routes[n]);

    }
}