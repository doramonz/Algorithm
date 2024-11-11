package SWEA;

import java.io.*;
import java.util.*;

public class SWEA1974 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < n; k++) {
            sb.append("#").append(k + 1).append(" ");
            int[][] map = new int[9][9];
            for (int i = 0; i < 9; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 9; j++)
                    map[i][j] = Integer.parseInt(st.nextToken()) - 1;
            }
            boolean flag = false;
            for (int i = 0; i < 9; i++) {
                boolean[] horizon = new boolean[9];
                boolean[] vertical = new boolean[9];
                boolean[] square = new boolean[9];
                for (int j = 0; j < 9; j++) {
                    horizon[map[i][j]] = true;
                    vertical[map[j][i]] = true;
                    square[map[i / 3 * 3 + j / 3][i % 3 * 3 + j % 3]] = true;
                }
                for (int j = 0; j < 9; j++) {
                    if (!horizon[j] || !vertical[j] || !square[j]) {
                        sb.append("0").append("\n");
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }
            if (!flag) {
                sb.append("1").append("\n");
            }
        }
        System.out.println(sb);
    }
}
