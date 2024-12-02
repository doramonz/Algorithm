package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1238 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= n; j++)
                arr[i][j] = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[a][b] = v;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (i == j || i == k)
                        continue;
                    if (arr[j][i] == Integer.MAX_VALUE || arr[i][k] == Integer.MAX_VALUE)
                        continue;
                    arr[j][k] = Math.min(arr[j][k], arr[j][i] + arr[i][k]);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        arr[x][x] = 0;
        for (int i = 1; i <= n; i++)
            max = Math.max(max, arr[i][x] + arr[x][i]);
        System.out.println(max);
    }
}
