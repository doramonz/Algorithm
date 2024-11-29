package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1992 {
    static StringBuilder sb = new StringBuilder();

    static void recur(int[][] map, int y, int x, int size) {
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
            sb.append(num);
            return;
        }
        int newSize = size / 2;
        sb.append("(");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                recur(map, y + i * newSize, x + j * newSize, newSize);
            }
        }
        sb.append(")");

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        recur(map, 0, 0, n);
        System.out.println(sb);
    }
}
