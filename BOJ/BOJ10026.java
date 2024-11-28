package BOJ;

import java.io.*;
import java.util.*;

public class BOJ10026 {
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        int normal = 0;
        int blind = 0;
        boolean[][] visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visit[i][j])
                    continue;
                Queue<int[]> queue = new ArrayDeque<>();
                normal++;
                visit[i][j] = true;
                queue.add(new int[] { i, j, map[i][j] });
                while (!queue.isEmpty()) {
                    int[] v = queue.poll();
                    for (int k = 0; k < 4; k++) {
                        int ny = v[0] + dy[k];
                        int nx = v[1] + dx[k];
                        if (ny < 0 || nx < 0 || ny >= n || nx >= n)
                            continue;
                        if (visit[ny][nx])
                            continue;
                        if (map[ny][nx] != (char) v[2])
                            continue;
                        visit[ny][nx] = true;
                        queue.add(new int[] { ny, nx, v[2] });
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'G')
                    map[i][j] = 'R';
            }
        }
        visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visit[i][j])
                    continue;
                Queue<int[]> queue = new ArrayDeque<>();
                blind++;
                visit[i][j] = true;
                queue.add(new int[] { i, j, map[i][j] });
                while (!queue.isEmpty()) {
                    int[] v = queue.poll();
                    for (int k = 0; k < 4; k++) {
                        int ny = v[0] + dy[k];
                        int nx = v[1] + dx[k];
                        if (ny < 0 || nx < 0 || ny >= n || nx >= n)
                            continue;
                        if (visit[ny][nx])
                            continue;
                        if (map[ny][nx] != (char) v[2])
                            continue;
                        visit[ny][nx] = true;
                        queue.add(new int[] { ny, nx, v[2] });
                    }
                }
            }
        }
        System.out.println(normal + " " + blind);
    }
}
