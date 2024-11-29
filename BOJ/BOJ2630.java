package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2630 {
    static int[] result = new int[2];

    static void recur(int[][] map, int x, int y, int size) {
        int num = map[y][x];
        boolean flag = false;
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (map[i][j] != num) {
                    flag = true;
                    break;
                }
            }
            if (flag)
                break;
        }
        if (!flag) {
            result[num]++;
            return;
        }
        int newSize = size / 2;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                recur(map, x + j * newSize, y + i * newSize, newSize);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }
        recur(map, 0, 0, n);
        for (int i = 0; i < 2; i++)
            System.out.println(result[i]);
    }
}
