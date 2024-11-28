package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2667 {
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                if (s.charAt(j) == '0')
                    map[i][j] = -1;
            }
        }
        int number = 0;
        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 0)
                    continue;
                int current_number = ++number;
                map[i][j] = current_number;
                deque.add(new int[] { i, j });
                while (!deque.isEmpty()) {
                    int[] v = deque.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = v[1] + dx[k];
                        int ny = v[0] + dy[k];
                        if (nx < 0 || ny < 0 || nx >= n || ny >= n)
                            continue;
                        if (map[ny][nx] != 0)
                            continue;
                        map[ny][nx] = current_number;
                        deque.add(new int[] { ny, nx });
                    }
                }
            }
        }
        int[] result = new int[number];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != -1) {
                    result[map[i][j]-1]++;
                }
            }
        }
        Arrays.sort(result);
        StringBuilder sb = new StringBuilder();
        sb.append(number).append("\n");
        for (int i = 0; i < number; i++)
            sb.append(result[i]).append("\n");
        System.out.println(sb);
    }
}
