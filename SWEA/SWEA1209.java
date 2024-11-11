package SWEA;

import java.io.*;
import java.util.*;

public class SWEA1209 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < 10; k++) {
            int nums = Integer.parseInt(br.readLine());
            sb.append("#" + nums + " ");
            int[][] map = new int[100][100];
            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int max = 0;
            int l_diagonal = 0;
            int r_diagonal = 0;
            for (int i = 0; i < 100; i++) {
                int h_sum = 0;
                int v_sum = 0;
                for (int j = 0; j < 100; j++) {
                    h_sum += map[i][j];
                    v_sum += map[j][i];
                }
                if (h_sum > max)
                    max = h_sum;
                if (v_sum > max)
                    max = v_sum;
                l_diagonal += map[99 - i][i];
                r_diagonal += map[i][i];
            }
            if (l_diagonal > max)
                max = l_diagonal;
            if (r_diagonal > max)
                max = r_diagonal;
            sb.append(max + "\n");
        }
        System.out.println(sb);
    }
}
