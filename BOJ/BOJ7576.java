package BOJ;

import java.io.*;
import java.util.*;

public class BOJ7576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] xy = br.readLine().split(" ");
        int x = Integer.parseInt(xy[1]);
        int y = Integer.parseInt(xy[0]);

        int[][] map = new int[x][y];
        for (int i = 0; i < x; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < y; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        Queue<Integer[]> queue = new ArrayDeque<>();
        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (map[i][j] != 1)
                    continue;
                queue.add(new Integer[] { i, j });
            }
        }
        while (!queue.isEmpty()) {
            Integer[] v = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = v[0] + dx[k];
                int ny = v[1] + dy[k];
                if (nx < 0 || ny < 0 || nx >= x || ny >= y)
                    continue;
                if (map[nx][ny] == 1 || map[nx][ny] == -1)
                    continue;
                if (map[nx][ny] != 0)
                    continue;
                map[nx][ny] = map[v[0]][v[1]] + 1;
                queue.add(new Integer[] { nx, ny });
            }
        }
        int max = 0;
        boolean none = false;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (map[i][j] > max)
                    max = map[i][j];
                if (map[i][j] == 0)
                    none = true;
            }
        }
        if (none) {
            System.out.println(-1);
        } else {
            System.out.println(max - 1);
        }
    }
}
