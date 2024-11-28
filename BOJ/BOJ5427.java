package BOJ;

import java.io.*;
import java.util.*;

public class BOJ5427 {
    static int[] dy = { 0, 1, 0, -1 };
    static int[] dx = { 1, 0, -1, 0 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t_case = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < t_case; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            char[][] map = new char[n][m];
            for (int i = 0; i < n; i++) {
                String s = br.readLine();
                for (int j = 0; j < m; j++) {
                    map[i][j] = s.charAt(j);
                }
            }
            int[][] fire = new int[n][m];
            int[][] human = new int[n][m];
            int count = 0;
            Queue<int[]> queue = new ArrayDeque<>();
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    if (map[i][j] == '*') {
                        fire[i][j] = 1;
                        queue.add(new int[] { i, j, 1 });
                    }
            while (!queue.isEmpty()) {
                int[] v = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int ny = v[0] + dy[i];
                    int nx = v[1] + dx[i];
                    if (ny < 0 || nx < 0 || ny >= n || nx >= m)
                        continue;
                    if (fire[ny][nx] != 0)
                        continue;
                    if (map[ny][nx] == '#')
                        continue;
                    fire[ny][nx] = v[2] + 1;
                    queue.add(new int[] { ny, nx, v[2] + 1 });
                }
            }
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    if (map[i][j] == '@') {
                        human[i][j] = 1;
                        queue.add(new int[] { i, j, 1 });
                    }
            while (!queue.isEmpty()) {
                int[] v = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int ny = v[0] + dy[i];
                    int nx = v[1] + dx[i];
                    if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                        count = v[2];
                        queue.clear();
                        break;
                    }
                    if (human[ny][nx] != 0)
                        continue;
                    if (map[ny][nx] != '.')
                        continue;
                    if (v[2] + 1 >= fire[ny][nx]&&fire[ny][nx]!=0)
                        continue;
                    human[ny][nx] = v[2] + 1;
                    queue.add(new int[] { ny, nx, v[2] + 1 });
                }
            }
            if (count != 0)
                sb.append(count);
            else
                sb.append("IMPOSSIBLE");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
