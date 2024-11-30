package BOJ;

import java.io.*;

public class BOJ2448 {
    static char[][] map;

    static void recur(int size, int y, int x) {
        if (size == 3) {
            map[y][x] = '*';
            map[y + 1][x - 1] = '*';
            map[y + 1][x + 1] = '*';
            for (int i = 0; i < 5; i++)
                map[y + 2][x - 2 + i] = '*';
            return;
        }
        recur(size / 2, y, x);
        recur(size/2, y+size/2, x-size/2);
        recur(size/2, y+size/2, x+size/2);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new char[n][n*2-1];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n*2-1; j++)
                map[i][j] = ' ';
        recur(n, 0, n - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n*2-1; j++)
                sb.append(map[i][j]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
