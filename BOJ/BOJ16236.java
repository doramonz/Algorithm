package BOJ;

import java.io.*;
import java.util.*;

public class BOJ16236 {
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        int[] pos = new int[3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    pos[0] = i;
                    pos[1] = j;
                    pos[2] = 0;
                    map[i][j] = 0;
                }
            }
        }
        int size = 2;
        int time = 0;
        int eat = 0;
        Deque<int[]> deque = new ArrayDeque<>();
        int[][] visit = new int[n][n];
        while (true) {
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    visit[i][j] = 0;
            boolean isEat = false;
            deque.add(pos);
            visit[pos[0]][pos[1]] = pos[2];
            while (!deque.isEmpty()) {
                int[] v = deque.poll();
                for (int k = 0; k < 4; k++) {
                    int nx = v[1] + dx[k];
                    int ny = v[0] + dy[k];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= n)
                        continue;
                    if (map[ny][nx] > size)
                        continue;
                    if (visit[ny][nx] != 0)
                        continue;
                    visit[ny][nx] = v[2] + 1;
                    deque.add(new int[] { ny, nx, v[2] + 1 });
                }
            }
            int y = 0;
            int x = 0;
            int t = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] != 0 && map[i][j] < size && visit[i][j] != 0 && visit[i][j] < t) {
                        y = i;
                        x = j;
                        t = visit[i][j];
                        isEat = true;
                    }
                }
            }
            if (!isEat)
                break;
            map[y][x] = 0;
            time += t;
            pos[0] = y;
            pos[1] = x;
            eat++;
            if (eat >= size) {
                eat = 0;
                size++;
            }
        }
        System.out.println(time);
    }
}
