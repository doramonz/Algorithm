package BOJ;

import java.util.Scanner;

public class BOJ12852 {

    private static int[] size;
    private static int[] rou;

    public static void func(int n) {
        size = new int[n + 1];
        rou = new int[n + 1];

        size[1] = 0;
        rou[1] = 0;
        if (n == 1)
            return;
        size[2] = 1;
        rou[2] = 1;
        if (n == 2)
            return;
        size[3] = 1;
        rou[3] = 1;

        for (int i = 4; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            if (i % 3 == 0 && size[i % 3] < min) {
                index = i % 3;
                min = size[index];
            }
            if (i % 2 == 0 && size[i % 2] < min) {
                index = i % 2;
                min = size[index];
            }
            if (size[i - 1] < min) {
                index = i - 1;
                min = size[index];
            }
            size[i] = size[index] + 1;
            rou[i] = index;
        }
    }

    public static void main(String[] args) {
        int n;

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        scanner.close();
        func(n);
        System.out.println(size[n]);

    }
}
