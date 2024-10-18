package BOJ;

import java.io.*;
import java.util.*;

public class BOJ15683 {
    static int[][] map;
    static List<int[]> cctv;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };
    static int min = Integer.MAX_VALUE;

    static void fill(int x, int y, int direction, int[][] cctvMap) {
        direction %= 4;
        while (true) {
            x += dx[direction];
            y += dy[direction];
            if (x < 0 || x >= map.length || y < 0 || y >= map[0].length || map[x][y] == 6)
                break;
            if (map[x][y] == 0) 
                cctvMap[x][y]++;
        }
    }

    static void unfill(int x, int y, int direction, int[][] cctvMap) {
        direction %= 4;
        while (true) {
            x += dx[direction];
            y += dy[direction];
            if (x < 0 || x >= map.length || y < 0 || y >= map[0].length || map[x][y] == 6)
                break;
            if (map[x][y] == 0 && cctvMap[x][y] > 0)
                cctvMap[x][y]--;
        }
    }

    static void func(int n, int[][] cctvMap) {
        if (n == cctv.size()) {
            int count = 0;
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    if (map[i][j] == 0 && cctvMap[i][j] == 0)
                        count++;
                }
            }
            min = Math.min(min, count);
            return;
        }

        int[] current = cctv.get(n);
        int cctvType = current[0];
        int cctvX = current[1];
        int cctvY = current[2];

        for (int j = 0; j < 4; j++) {
            if (cctvType == 1) {
                fill(cctvX, cctvY, j, cctvMap);
                func(n + 1, cctvMap);
                unfill(cctvX, cctvY, j, cctvMap);
            } else if (cctvType == 2) {
                fill(cctvX, cctvY, j, cctvMap);
                fill(cctvX, cctvY, j + 2, cctvMap);
                func(n + 1, cctvMap);
                unfill(cctvX, cctvY, j, cctvMap);
                unfill(cctvX, cctvY, j + 2, cctvMap);
            } else if (cctvType == 3) {
                fill(cctvX, cctvY, j, cctvMap);
                fill(cctvX, cctvY, j + 1, cctvMap);
                func(n + 1, cctvMap);
                unfill(cctvX, cctvY, j, cctvMap);
                unfill(cctvX, cctvY, j + 1, cctvMap);
            } else if (cctvType == 4) {
                fill(cctvX, cctvY, j, cctvMap);
                fill(cctvX, cctvY, j + 1, cctvMap);
                fill(cctvX, cctvY, j + 2, cctvMap);
                func(n + 1, cctvMap);
                unfill(cctvX, cctvY, j, cctvMap);
                unfill(cctvX, cctvY, j + 1, cctvMap);
                unfill(cctvX, cctvY, j + 2, cctvMap);
            } else if (cctvType == 5) {
                fill(cctvX, cctvY, j, cctvMap);
                fill(cctvX, cctvY, j + 1, cctvMap);
                fill(cctvX, cctvY, j + 2, cctvMap);
                fill(cctvX, cctvY, j + 3, cctvMap);
                func(n + 1, cctvMap);
                unfill(cctvX, cctvY, j, cctvMap);
                unfill(cctvX, cctvY, j + 1, cctvMap);
                unfill(cctvX, cctvY, j + 2, cctvMap);
                unfill(cctvX, cctvY, j + 3, cctvMap);
            }
        }
    }

    public static void main(String[] args) throws IOException {
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
        cctv = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0 && map[i][j] != 6)
                    cctv.add(new int[] { map[i][j], i, j });
            }
        }
        int[][] initialMap = new int[n][m];
        func(0, initialMap);
        System.out.println(min);
    }
}