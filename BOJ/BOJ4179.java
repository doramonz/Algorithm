package BOJ;

import java.io.*;
import java.util.*;

public class BOJ4179 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] xy = br.readLine().split(" ");
        int x = Integer.parseInt(xy[0]);
        int y = Integer.parseInt(xy[1]);

        Queue<int[]> fire_queue = new ArrayDeque();
        Queue<int[]> jihoon_queue = new ArrayDeque();

        int[][] fire_map = new int[x][y];
        int[][] jihoon_map = new int[x][y];
        char[][] map = new char[x][y];

        for (int i = 0; i < x; i++) {
            String temp = br.readLine();
            for (int j = 0; j < y; j++) {
                map[i][j] = temp.charAt(j);
                fire_map[i][j] = -1;
                jihoon_map[i][j] = -1;
                if (map[i][j] == 'J') {
                    jihoon_map[i][j] = 1;
                    jihoon_queue.add(new int[] { i, j });
                }
                if (map[i][j] == 'F') {
                    fire_map[i][j] = 1;
                    fire_queue.add(new int[] { i, j });
                }
            }
        }

        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        while (!fire_queue.isEmpty()) {
            int[] v = fire_queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = v[0] + dx[i];
                int ny = v[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= x || ny >= y)
                    continue;
                if (map[nx][ny] == '#' || fire_map[nx][ny] != -1)
                    continue;
                fire_map[nx][ny] = fire_map[v[0]][v[1]] + 1;
                fire_queue.add(new int[] { nx, ny });
            }
        }

        while (!jihoon_queue.isEmpty()) {
            int[] v = jihoon_queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = v[0] + dx[i];
                int ny = v[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= x || ny >= y) {
                    System.out.println(jihoon_map[v[0]][v[1]]);
                    return;
                }
                if (map[nx][ny] == '#' || jihoon_map[nx][ny] != -1 || (jihoon_map[v[0]][v[1]] + 1 >= fire_map[nx][ny]
                        && fire_map[nx][ny] != -1))
                    continue;
                jihoon_map[nx][ny] = jihoon_map[v[0]][v[1]] + 1;
                jihoon_queue.add(new int[] { nx, ny });
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}
