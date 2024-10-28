package BOJ;

import java.io.*;
import java.util.*;

public class BOJ12100 {

    static int max = 0;

    static void func2048(int[][] map, int n) {
        if (n == 5) {
            // calculate max
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    max = Math.max(max, map[i][j]);
                }
            }
            return;
        }
        // left
        int temp[][] = new int[map.length][map.length];
        for (int i = 0; i < map.length; i++) {
            int index = 0;
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == 0)
                    continue;
                if (temp[i][index] == 0) {
                    temp[i][index] = map[i][j];
                } else if (temp[i][index] == map[i][j]) {
                    temp[i][index++] *= 2;
                } else {
                    temp[i][++index] = map[i][j];
                }
            }
        }
        func2048(temp, n + 1);
        // top
        temp = new int[map.length][map.length];
        for (int i = 0; i < map.length; i++) {
            int index = 0;
            for (int j = 0; j < map.length; j++) {
                if (map[j][i] == 0)
                    continue;
                if (temp[index][i] == 0) {
                    temp[index][i] = map[j][i];
                } else if (temp[index][i] == map[j][i]) {
                    temp[index++][i] *= 2;
                } else {
                    temp[++index][i] = map[j][i];
                }
            }
        }
        func2048(temp, n + 1);
        // right
        temp = new int[map.length][map.length];
        for (int i = map.length - 1; i >= 0; i--) {
            int index = map.length - 1;
            for (int j = map.length - 1; j >= 0; j--) {
                if (map[i][j] == 0)
                    continue;
                if (temp[i][index] == 0) {
                    temp[i][index] = map[i][j];
                } else if (temp[i][index] == map[i][j]) {
                    temp[i][index--] *= 2;
                } else {
                    temp[i][--index] = map[i][j];
                }
            }
        }
        func2048(temp, n + 1);
        // bottom
        temp = new int[map.length][map.length];
        for (int i = map.length - 1; i >= 0; i--) {
            int index = map.length - 1;
            for (int j = map.length - 1; j >= 0; j--) {
                if (map[j][i] == 0)
                    continue;
                if (temp[index][i] == 0) {
                    temp[index][i] = map[j][i];
                } else if (temp[index][i] == map[j][i]) {
                    temp[index--][i] *= 2;
                } else {
                    temp[--index][i] = map[j][i];
                }
            }
        }
        func2048(temp, n + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        func2048(map, 0);

        System.out.println(max);
    }
}
