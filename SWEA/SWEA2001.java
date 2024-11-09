package SWEA;

import java.io.*;
import java.util.*;

public class SWEA2001 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][n];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int h = 0; h < n; h++)
                    arr[j][h] = Integer.parseInt(st.nextToken());
            }
            int max = 0;
            for (int j = 0; j <= n - m; j++) {
                for (int k = 0; k <= n - m; k++) {
                    int sum = 0;
                    for (int x = 0; x < m; x++) {
                        for (int y = 0; y < m; y++) {
                            sum += arr[j + x][k + y];
                        }
                    }
                    max = Math.max(max, sum);
                }
            }
            sb.append("#").append(i+1).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }
}
