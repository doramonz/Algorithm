package BOJ;

import java.io.*;
import java.util.*;

public class BOJ20058 {
    static int[][] map;
    static int mapSize;
    static int n;
    static int[] magic;
    static int[] dr = { 0, 1, 0, -1 };
    static int[] dc = { 1, 0, -1, 0 };

    static void rotate(int i, int j, int power) {
        if (power == 0)
            return;
        int[][] newMap = new int[1<<power][1<<power];
        for (int n = 0; n < 1<<power; n++) {
            for (int m = 0; m < 1<<power; m++) {
                newMap[m][(1<<power) - 1 - n] = map[n + i][m + j];
            }
        }
        for (int n = 0; n < 1<<power; n++) {
            for (int m = 0; m < 1<<power; m++) {
                map[n + i][m + j] = newMap[n][m];
            }
        }
    }

    static boolean isMoreThreeGlacier(int r, int c) {
        int count = 0;
        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (nr >= 0 && nc >= 0 && nr < mapSize && nc < mapSize && map[nr][nc] > 0)
                count++;
        }
        return count >= 3;
    }

    static int getSumAllGlacier() {
        int count = 0;
        for (int i = 0; i < mapSize; i++)
            for (int j = 0; j < mapSize; j++)
                count += map[i][j];
        return count;
    }

    static int getBigestGlacier() {
        boolean[][] vis = new boolean[mapSize][mapSize];
        int max = 0;
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if (!vis[i][j]&&map[i][j]>0) {
                    max = Math.max(max, bfs(vis, i, j));
                }
            }
        }
        return max;
    }

    static int bfs(boolean[][] vis, int r, int c) {
        int count = 1;
        Deque<int[]> deque = new ArrayDeque<>();
        vis[r][c] = true;
        deque.add(new int[] { r, c });
        while (!deque.isEmpty()) {
            int[] v = deque.poll();
            for (int k = 0; k < 4; k++) {
                int nr = v[0] + dr[k];
                int nc = v[1] + dc[k];
                if (nr >= 0 && nc >= 0 && nr < mapSize && nc < mapSize && !vis[nr][nc]&&map[nr][nc]>0) {
                    count++;
                    vis[nr][nc] = true;
                    deque.add(new int[] { nr, nc });
                }
            }
        }
        return count;
    }

    static void magic(int power) {
        for (int i = 0; i < mapSize; i += 1 << power) {
            for (int j = 0; j < mapSize; j += 1 << power)
                rotate(i, j, power);
        }
        int[][] newMap = new int[mapSize][mapSize];
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                newMap[i][j] = map[i][j];
                if (!isMoreThreeGlacier(i, j)&&map[i][j]>0)
                    newMap[i][j]--;
            }
        }
        map = newMap;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        mapSize = 2 << (n - 1);
        map = new int[mapSize][mapSize];
        magic = new int[q];
        for (int i = 0; i < mapSize; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < mapSize; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++)
            magic[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < q; i++)
            magic(magic[i]);
        System.out.println(getSumAllGlacier());
        System.out.println(getBigestGlacier());
    }
}
