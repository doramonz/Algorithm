package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1717 {
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        rank = new int[n + 1];
        for(int i = 1;i<=n;i++){
            arr[i] = i;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            if (st.nextToken().equals("0")) {
                union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            } else {
                sb.append(find(Integer.parseInt(st.nextToken())) == find(Integer.parseInt(st.nextToken())) ? "YES"
                        : "NO").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
