package BOJ;

import java.io.*;
import java.util.*;

public class BOJ11404 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        long[][] cost = new long[n][n];
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            if (cost[a][b] == 0)
                cost[a][b] = Integer.MAX_VALUE;
            cost[a][b] = Math.min(cost[a][b], c);
        }
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (i != j && cost[i][j] == 0)
                    cost[i][j] = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (j == k || i == j)
                        continue;
                    cost[j][k] = Math.min(cost[j][k], cost[j][i] + cost[i][k]);
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
        System.out.println(sb.toString());
    }
}
