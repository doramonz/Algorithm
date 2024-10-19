package BOJ;

import java.io.*;
import java.util.*;

public class BOJ14502 {
    static int[][] map;
    static int maxEmptyTile = 0;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };

    static void func(int currentWallCount, int n) {
        if (currentWallCount == 3) {
            int count = 0;
            // virus bfs
            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++)
                    if (map[i][j] == 2)
                        queue.add(new int[] { i, j });
            }
            boolean[][] virusMap = new boolean[map.length][map[0].length];

            while (!queue.isEmpty()) {
                int[] v = queue.poll();
                virusMap[v[0]][v[1]] = true;
                for (int i = 0; i < 4; i++) {
                    int nx = dx[i] + v[0];
                    int ny = dy[i] + v[1];
                    if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length)
                        continue;
                    if (map[nx][ny] == 1)
                        continue;
                    if (virusMap[nx][ny])
                        continue;
                    virusMap[nx][ny] = true;
                    queue.add(new int[] { nx, ny });
                }
            }
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++)
                    if (map[i][j] == 0 && !virusMap[i][j])
                        count++;
            }

            maxEmptyTile = Math.max(maxEmptyTile, count);
            return;
        }

        for (int i = n; i < map.length * map[0].length; i++) {
            int x = i / map[0].length;
            int y = i % map[0].length;
            if (map[x][y] == 2 || map[x][y] == 1)
                continue;
            map[x][y] = 1;
            func(currentWallCount + 1, i);
            map[x][y] = 0;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            temp = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }
        func(0, 0);
        System.out.println(maxEmptyTile);
    }
}
