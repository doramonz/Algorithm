package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1012 {
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t_case = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < t_case; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            boolean[][] map = new boolean[m][n];
            for (int i = 0; i < p; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = true;
            }
            int count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (!map[i][j])
                        continue;
                    Queue<int[]> queue = new ArrayDeque<>();
                    count++;
                    map[i][j] = false;
                    queue.add(new int[] { i, j });
                    while (!queue.isEmpty()) {
                        int[] v = queue.poll();
                        for (int r = 0; r < 4; r++) {
                            int ny = v[0] + dy[r];
                            int nx = v[1] + dx[r];
                            if (ny < 0 || nx < 0 || ny >= m || nx >= n)
                                continue;
                            if (!map[ny][nx])
                                continue;
                            map[ny][nx] = false;
                            queue.add(new int[] { ny, nx });
                        }
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
