package BOJ;

import java.util.Scanner;

public class BOJ1726 {

    private static int[] size;

    private static int box(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (size[n] != 0) {
            return size[n];
        }
        size[n] = box(n - 1) + box(n - 2);
        return size[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        size = new int[n + 1];
        System.out.println(box(n)/10007);
    }
}