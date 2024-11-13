package SWEA;

import java.io.*;
import java.util.*;

public class SWEA1979 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nums = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int k = 1; k <= nums; k++) {
            sb.append("#" + k + " ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            boolean[][] map = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = st.nextToken().equals("1");
                }
            }
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j + m - 1 < n; j++) {
                    if ((j != 0 && map[i][j - 1]) || (j + m != n && map[i][j + m]))
                        continue;
                    for (int h = 0; h < m; h++) {
                        if (!map[i][j + h])
                            break;
                        if (h == m - 1)
                            count++;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j + m - 1 < n; j++) {
                    if ((j!=0 && map[j - 1][i]) || (j+m!=n && map[j + m][i]))
                        continue;
                    for (int h = 0; h < m; h++) {
                        if (!map[j + h][i])
                            break;
                        if (h == m - 1)
                            count++;
                    }
                }
            }
            sb.append(count + "\n");
        }
        System.out.println(sb);
    }
}
