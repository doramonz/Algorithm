package BOJ;

import java.io.*;
import java.util.*;

public class BOJ7562 {
    static int[] dx = { -2, -2, -1, -1, 1, 1, 2, 2 };
    static int[] dy = { 1, -1, 2, -2, 2, -2, 1, -1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t_case = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < t_case; t++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] current = new int[2];
            current[0] = Integer.parseInt(st.nextToken());
            current[1] = Integer.parseInt(st.nextToken());
            int[] dest = new int[2];
            st = new StringTokenizer(br.readLine());
            dest[0] = Integer.parseInt(st.nextToken());
            dest[1] = Integer.parseInt(st.nextToken());
            Deque<int[]> deque = new ArrayDeque<>();
            boolean[][] visit = new boolean[n][n];
            visit[current[0]][current[1]] = true;
            deque.add(new int[] { current[0], current[1], 0 });
            while (!deque.isEmpty()) {
                int[] v = deque.poll();
                if (dest[0] == v[0] && dest[1] == v[1]) {
                    sb.append(v[2]).append("\n");
                    break;
                }
                for (int i = 0; i < 8; i++) {
                    int ny = v[0] + dy[i];
                    int nx = v[1] + dx[i];
                    if (ny < 0 || nx < 0 || ny >= n || nx >= n)
                        continue;
                    if (visit[ny][nx])
                        continue;
                    visit[ny][nx] = true;
                    deque.add(new int[] { ny, nx, v[2] + 1 });
                }
            }
        }
        System.out.println(sb);
    }
}
