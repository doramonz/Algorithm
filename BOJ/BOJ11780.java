package BOJ;

import java.io.*;
import java.util.*;

public class BOJ11780 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        long[][] cost = new long[n][n];
        int[][] path = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                    path[i][j] = -1;
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            if (cost[a][b] == 0)
                cost[a][b] = Integer.MAX_VALUE;
            cost[a][b] = Math.min(cost[a][b], c);
            path[a][b] = b;
        }
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (i != j && cost[i][j] == 0) {
                    cost[i][j] = Integer.MAX_VALUE;
                }
            }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (j == k || i == j)
                        continue;
                    if (cost[j][i] + cost[i][k] < cost[j][k]) {
                        cost[j][k] = cost[j][i] + cost[i][k];
                        path[j][k] = path[j][i];
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cost[i][j] == Integer.MAX_VALUE)
                    cost[i][j] = 0;
                sb.append(cost[i][j] + " ");
            }
            sb.append("\n");
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                StringBuilder sb2 = new StringBuilder();
                if (path[i][j] != -1) {
                    count+=2;
                    sb2.append(i + 1).append(" ");
                    int locate = path[i][j];
                    while(locate!=j){
                        count++;
                        sb2.append(locate + 1).append(" ");
                        locate = path[locate][j];
                    }
                    sb2.append(locate+1).append(" ");
                }
                sb.append(count).append(" ").append(sb2).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
