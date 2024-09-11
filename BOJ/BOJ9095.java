package BOJ;

import java.util.Scanner;

public class BOJ9095 {

    public static void main(String[] args) {
        int n;
        int[] nums;
        int[] arr = new int[11];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 4;
        for (int i = 3; i < 11; i++) {
            arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
        }

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        scanner.close();
        for (int i = 0; i < n; i++) {
            System.out.println(arr[nums[i]-1]);
        }
    }

}
