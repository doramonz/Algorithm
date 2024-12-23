package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2606 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean[][] connections = new boolean[n][n];
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            connections[a - 1][b - 1] = true;
            connections[b - 1][a - 1] = true;
        }
        boolean[] vis = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        vis[0] = true;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int i = 0; i < n; i++) {
                if (connections[v][i] && !vis[i]) {
                    queue.add(i);
                    vis[i] = true;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++)
            if (vis[i])
                count++;
        System.out.println(count-1);
    }
}
