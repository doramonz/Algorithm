package BOJ;

import java.util.*;
import java.io.*;

public class BOJ9372 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t_case = Integer.parseInt(br.readLine());
        for (int t = 0; t < t_case; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            boolean[][] fs = new boolean[n][n];
            for (int i = 0; i < f; i++) {
                st = new StringTokenizer(br.readLine());
                fs[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = true;
            }
            int count = 0;
            Queue<Integer> queue = new ArrayDeque<>();
            boolean[] vis = new boolean[n];
            vis[0] = true;
            queue.add(0);
            while (!queue.isEmpty()) {
                int v = queue.poll();
                for (int i = 0; i < n; i++) {
                    if (!vis[i]) {
                        count++;
                        vis[i] = true;
                        queue.add(i);
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
