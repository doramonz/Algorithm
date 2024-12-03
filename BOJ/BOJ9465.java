package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ9465 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t_case = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < t_case; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n];
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++)
                    arr[i][j] = Integer.parseInt(st.nextToken());
            }
            if (n > 1) {
                arr[0][1] = arr[1][0] + arr[0][1];
                arr[1][1] = arr[0][0] + arr[1][1];
            }
            for (int i = 2; i < n; i++) {
                arr[0][i] = Math.max(arr[0][i - 2], Math.max(arr[1][i - 2], arr[1][i - 1])) + arr[0][i];
                arr[1][i] = Math.max(arr[0][i - 2], Math.max(arr[1][i - 2], arr[0][i - 1])) + arr[1][i];
            }
            int max = 0;
            for (int i = 0; i < n; i++) {
                max = Math.max(max, Math.max(arr[0][i], arr[1][i]));
            }
            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }
}
