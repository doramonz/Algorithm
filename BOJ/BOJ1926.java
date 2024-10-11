package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int x = Integer.parseInt(s[0]);
        int y = Integer.parseInt(s[1]);
        String[] temp;
        boolean[][] map = new boolean[x][y];
        for (int i = 0; i < x; i++) {
            temp = br.readLine().split(" ");
            for (int j = 0; j < y; j++) {
                if (temp[j].equals("1")) {
                    map[i][j] = true;
                } else {
                    map[i][j] = false;
                }
            }
        }

        boolean[][] visit = new boolean[x][y];
        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        int max = 0;
        int area = 0;
        Queue<Integer[]> queue = new ArrayDeque<>();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                int count = 0;
                if (map[i][j] && !visit[i][j]) {
                    visit[i][j] = true;
                    count++;
                    area++;
                    queue.add(new Integer[] { i, j });
                    while (!queue.isEmpty()) {
                        Integer[] point = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = point[0] + dx[k];
                            int ny = point[1] + dy[k];
                            if (nx < 0 || nx >= x || ny < 0 || ny >= y)
                                continue;
                            if (!map[nx][ny] || visit[nx][ny])
                                continue;
                            visit[nx][ny] = true;
                            count++;
                            queue.add(new Integer[] { nx, ny });
                        }
                    }
                    if (count > max)
                        max = count;
                }
            }
        }
        System.out.println(area + "\n" + max);
    }
}
