package BOJ;

import java.io.*;
import java.util.*;

public class BOJ11559 {
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] map = new char[12][6];
        for (int i = 0; i < 12; i++) {
            String s = br.readLine();
            for (int j = 0; j < 6; j++)
                map[i][j] = s.charAt(j);
        }
        int result = 0;
        while (true) {
            boolean flag = true;
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (map[i][j] == '.')
                        continue;
                    boolean[][] visit = new boolean[12][6];
                    char v = map[i][j];
                    int count = 1;
                    Deque<int[]> deque = new ArrayDeque<>();
                    Deque<int[]> remove = new ArrayDeque<>();
                    deque.add(new int[] { i, j });
                    remove.add(new int[] { i, j });
                    visit[i][j] = true;
                    while (!deque.isEmpty()) {
                        int[] p = deque.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = p[1] + dx[k];
                            int ny = p[0] + dy[k];
                            if (nx < 0 || ny < 0 || nx >= 6 || ny >= 12)
                                continue;
                            if (map[ny][nx] != v)
                                continue;
                            if (visit[ny][nx])
                                continue;
                            count++;
                            visit[ny][nx] = true;
                            deque.add(new int[] { ny, nx });
                            remove.add(new int[] { ny, nx });
                        }
                    }
                    if (count >= 4) {
                        for (int n = 0; n < 12; n++) {
                            for (int m = 0; m < 6; m++) {
                                if (visit[n][m]) {
                                    map[n][m] = '.';
                                }
                            }
                        }
                        for (int[] p : remove) {
                            map[p[0]][p[1]] = '.';
                        }
                        flag = false;
                    }
                }
            }
            if (flag)
                break;
            char[][] tempMap = new char[12][6];
            for (int n = 0; n < 6; n++) {
                int l = 11;
                for (int m = 11; m >=0; m--) {
                    if (map[m][n] != '.')
                        tempMap[l--][n] = map[m][n];
                }
                for (int m = l; m >= 0; m--)
                    tempMap[m][n] = '.';
            }
            map = tempMap;
            result++;
        }
        System.out.println(result);
    }
}
