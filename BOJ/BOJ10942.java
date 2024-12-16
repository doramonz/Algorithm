package BOJ;

import java.io.*;
import java.util.*;

public class BOJ10942 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        int[][] se = new int[m][];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            se[i] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
        }
        int[][] dp = new int[2001][2001];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int a = se[i][0];
            int b = se[i][1];
            while (b - a > 1 && dp[a][b] == 0) {
                a++;
                b--;
            }
            if (dp[a][b] == 0)
                dp[a][b] = arr[a - 1] == arr[b - 1] ? 1 : -1;
            while (a > se[i][0]) {
                a--;
                b++;
                dp[a][b] = dp[a + 1][b - 1] == 1 && arr[a - 1] == arr[b - 1] ? 1 : -1;
            }
            if(dp[a][b]==1){
                sb.append("1\n");
            }else{
                sb.append("0\n");
            }
        }
        System.out.println(sb);
    }
}
