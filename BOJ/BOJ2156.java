package BOJ;

import java.io.*;

public class BOJ2156 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++)
            arr[i][0] = Integer.parseInt(br.readLine());

        arr[0][1] = arr[0][0];
        
        if (n > 1) {
            arr[1][1] = arr[1][0];
            arr[1][2] = arr[0][0] + arr[1][0];
        }

        for (int i = 2; i < n; i++) {
            arr[i][1] = Math.max(Math.max(arr[i - 2][1], arr[i - 2][2]) + arr[i][0], arr[i - 1][2]);
            arr[i][2] = arr[i - 1][1] + arr[i][0];
        }

        System.out.println(Math.max(arr[n - 1][1], arr[n - 1][2]));
    }
}
