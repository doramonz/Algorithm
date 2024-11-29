package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2206 {
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                if (s.charAt(j) == '1')
                    map[i][j] = true;
            }
        }
        int min = Integer.MAX_VALUE;
        Queue<int[]> queue = new ArrayDeque<>();
        Queue<int[]> next_Queue = new ArrayDeque<>();
        int[][] count_map = new int[n][m];
        queue.add(new int[] { 0, 0, 1 });
        count_map[0][0] = 1;
        while (!queue.isEmpty()) {
            int[] v = queue.poll();
            if (v[0] == n - 1 && v[1] == m - 1)
                min = Math.min(v[2], min);
            for (int k = 0; k < 4; k++) {
                int ny = v[0] + dy[k];
                int nx = v[1] + dx[k];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m)
                    continue;
                if (map[ny][nx]) {
                    next_Queue.add(new int[] { ny, nx, v[2] + 1 });
                    continue;
                }
                if (count_map[ny][nx] != 0)
                    continue;
                count_map[ny][nx] = v[2] + 1;
                queue.add(new int[] { ny, nx, v[2] + 1 });
            }
        }
        count_map = new int[n][m];
        while (!next_Queue.isEmpty()) {
            int[] v = next_Queue.poll();
            if (v[0] == n - 1 && v[1] == m - 1)
                min = Math.min(v[2], min);
            for (int k = 0; k < 4; k++) {
                int ny = v[0] + dy[k];
                int nx = v[1] + dx[k];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m)
                    continue;
                if (map[ny][nx]) {
                    continue;
                }
                if (count_map[ny][nx] <= v[2] + 1 && count_map[ny][nx] != 0)
                    continue;
                count_map[ny][nx] = v[2] + 1;
                next_Queue.add(new int[] { ny, nx, v[2] + 1 });
            }
        }
        System.out.println(min != Integer.MAX_VALUE ? min : -1);
    }
}
