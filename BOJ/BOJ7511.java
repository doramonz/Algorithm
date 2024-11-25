package BOJ;

import java.io.*;
import java.util.*;

public class BOJ7511 {
    static int[] arr;
    static int[] rank;

    static int find(int x) {
        if (arr[x] == x)
            return x;
        return arr[x] = find(arr[x]);
    }

    static boolean union(int x, int y) {
        int a = find(x);
        int b = find(y);
        if (a == b)
            return false;
        if (rank[a] >= rank[b]) {
            if (rank[a] == rank[b])
                rank[a]++;
            arr[b] = a;
        } else {
            arr[a] = b;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append("Scenario ").append(i).append(":\n");
            int k = Integer.parseInt(br.readLine());
            arr = new int[k + 1];
            rank = new int[k + 1];
            for (int j = 1; j <= k; j++) {
                arr[j] = j;
            }
            k = Integer.parseInt(br.readLine());
            for (int j = 0; j < k; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            k = Integer.parseInt(br.readLine());
            for (int j = 0; j < k; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                sb.append(find(Integer.parseInt(st.nextToken())) == find(Integer.parseInt(st.nextToken())) ? 1 : 0)
                        .append("\n");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
