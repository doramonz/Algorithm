package BOJ;

import java.io.*;
import java.util.*;

public class BOJ7569 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] xyz = br.readLine().split(" ");
        int x = Integer.parseInt(xyz[1]);
        int y = Integer.parseInt(xyz[0]);
        int z = Integer.parseInt(xyz[2]);

        int[][][] map = new int[z][x][y];
        for (int o = 0; o < z; o++) {
            for (int i = 0; i < x; i++) {
                String[] temp = br.readLine().split(" ");
                for (int j = 0; j < y; j++) {
                    map[o][i][j] = Integer.parseInt(temp[j]);
                }
            }
        }

        Queue<Integer[]> queue = new ArrayDeque<>();
        int[] dz = { 0, 0, 0, 0, 1, -1 };
        int[] dx = { 1, 0, -1, 0, 0, 0 };
        int[] dy = { 0, 1, 0, -1, 0, 0 };
        for (int o = 0; o < z; o++) {
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (map[o][i][j] != 1)
                        continue;
                    queue.add(new Integer[] { o, i, j });
                }
            }
        }
        while (!queue.isEmpty()) {
            Integer[] v = queue.poll();
            for (int k = 0; k < 6; k++) {
                int nx = v[1] + dx[k];
                int ny = v[2] + dy[k];
                int nz = v[0] + dz[k];
                if (nx < 0 || ny < 0 || nz < 0 || nx >= x || ny >= y || nz >= z)
                    continue;
                if (map[nz][nx][ny] == 1 || map[nz][nx][ny] == -1)
                    continue;
                if (map[nz][nx][ny] != 0)
                    continue;
                map[nz][nx][ny] = map[v[0]][v[1]][v[2]] + 1;
                queue.add(new Integer[] { nz, nx, ny });
            }
        }
        int max = 0;
        boolean none = false;
        for (int o = 0; o < z; o++) {
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (map[o][i][j] > max)
                        max = map[o][i][j];
                    if (map[o][i][j] == 0)
                        none = true;
                }
            }
        }
        if (none) {
            System.out.println(-1);
        } else {
            System.out.println(max - 1);
        }
    }
}
