package BOJ;

import java.util.Scanner;

public class BOJ31403 {

    private static int[] getOperationResult(int a, int b, int c) {
        int[] result = new int[2];
        result[0] = a + b - c;
        int i = 0;
        int temp = b;
        while (temp > 0) {
            temp /= 10;
            i++;
        }
        result[1] = a;
        for (int j = 0; j < i; j++) {
            result[1] *= 10;
        }
        result[1] = result[1] + b - c;
        return result;
    }

    public static void main(String[] args) {
        int a, b, c;
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();
        scanner.close();
        int[] result = getOperationResult(a, b, c);
        System.out.println(result[0] + "\n" + result[1]);
    }
}
