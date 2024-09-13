package BOJ;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BOJ2217 {
    private static int getAveRope(Integer[] arr) {
        Arrays.sort(arr, Collections.reverseOrder());

        int maxWeight = 0;

        for (int i = 0; i < arr.length; i++) {
            int currentWeight = arr[i] * (i + 1);
            maxWeight = Math.max(maxWeight, currentWeight);
        }

        return maxWeight;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        System.out.println(getAveRope(arr));
    }
}
