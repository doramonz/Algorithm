package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2468 {
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = 0;
        for (int h = 1; h <= 100; h++) {
            boolean[][] visit = new boolean[n][n];
            Queue<int[]> queue = new ArrayDeque<>();
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visit[i][j] || map[i][j] < h)
                        continue;
                    count++;
                    visit[i][j] = true;
                    queue.add(new int[] { i, j });
                    while (!queue.isEmpty()) {
                        int[] v = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = v[1] + dx[k];
                            int ny = v[0] + dy[k];
                            if (nx < 0 || ny < 0 || nx >= n || ny >= n)
                                continue;
                            if (visit[ny][nx] || map[ny][nx] < h)
                                continue;
                            visit[ny][nx] = true;
                            queue.add(new int[] { ny, nx });
                        }
                    }
                }
            }
            max = Math.max(max, count);
        }
        System.out.println(max);
    }
}
