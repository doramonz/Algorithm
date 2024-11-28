package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2583 {
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++)
                    map[y][x] = -1;
            }
        }
        int index = 1;
        int c_index;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0)
                    continue;
                c_index = index++;
                map[i][j] = c_index;
                queue.add(new int[] { i, j });
                while (!queue.isEmpty()) {
                    int[] v = queue.poll();
                    for (int q = 0; q < 4; q++) {
                        int nx = v[1] + dx[q];
                        int ny = v[0] + dy[q];
                        if (nx < 0 || ny < 0 || nx >= m || ny >= n)
                            continue;
                        if (map[ny][nx] != 0)
                            continue;
                        map[ny][nx] = c_index;
                        queue.add(new int[] { ny, nx });
                    }
                }
            }
        }
        int[] result = new int[index - 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                if (map[i][j] != -1)
                    result[map[i][j]-1]++;
        }
        Arrays.sort(result);
        StringBuilder sb = new StringBuilder();
        sb.append(index-1).append("\n");
        for (int i = 0; i < index - 1; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }
}
