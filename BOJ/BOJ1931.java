package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1931 {
    private static int getMeetingTime(int n, int[][] arr) {

        Arrays.sort(arr, (x, y) -> {
            if(x[1]==y[1]){
                return x[0]-y[0];
            }
            return x[1] - y[1];
        });

        int count = 0;
        int time = 0;

        for(int i = 0;i<n;i++){
            if(arr[i][0]>=time){
                count++;
                time = arr[i][1];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
        }
        scanner.close();

        System.out.println(getMeetingTime(n, arr));
    }
}
