package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] xy = br.readLine().split(" ");

        int x = Integer.parseInt(xy[0]);
        int y = Integer.parseInt(xy[1]);

        boolean[][] map = new boolean[x][y];
        int[][] weight = new int[x][y];

        for (int i = 0; i < x; i++) {
            String temp = br.readLine();
            for (int j = 0; j < y; j++) {
                if (temp.charAt(j) == '1') {
                    map[i][j] = true;
                } else {
                    map[i][j] = false;
                }
                weight[i][j] = Integer.MAX_VALUE;
            }
        }

        Queue<Integer[]> queue = new ArrayDeque<>();
        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        weight[0][0] = 1;
        queue.add(new Integer[] { 0, 0 });

        while (!queue.isEmpty()) {
            Integer[] v = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = v[0] + dx[i];
                int ny = v[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= x || ny >= y)
                    continue;
                if (!map[nx][ny] || weight[v[0]][v[1]] + 1 >= weight[nx][ny])
                    continue;
                weight[nx][ny] = weight[v[0]][v[1]] + 1;
                queue.add(new Integer[] { nx, ny });
            }
        }
        System.out.println(weight[x-1][y-1]);
    }
}
