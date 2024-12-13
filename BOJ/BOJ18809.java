package BOJ;

import java.io.*;
import java.util.*;

public class BOJ18809 {
    static int greenFertilizeCount;
    static int redFertilizeCount;
    static int[][] map;
    static int n;
    static int m;
    static List<int[]> fertilizablePoint = new ArrayList<>();
    static boolean[] used;
    static int maxFlowerCount = 0;
    static List<int[]> greenList = new ArrayList<>();
    static List<int[]> redList = new ArrayList<>();

    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };

    static void flowerCount(int gc, int rc, int index1, int index2) {
        if (gc == greenFertilizeCount && rc == redFertilizeCount) {
            int flowerCount = 0;
            int[][] visit = new int[n][m];
            int[][] type = new int[n][m];
            Deque<int[]> deque = new ArrayDeque<>();
            for (int[] v : greenList) {
                visit[v[0]][v[1]] = 1;
                type[v[0]][v[1]] = 1;
                deque.add(new int[] { v[0], v[1], 1, 1 });
            }
            for (int[] v : redList) {
                visit[v[0]][v[1]] = 1;
                type[v[0]][v[1]] = 2;
                deque.add(new int[] { v[0], v[1], 1, 2 });
            }
            while (!deque.isEmpty()) {
                int[] v = deque.poll();
                if (type[v[0]][v[1]] == 3)
                    continue;

                for (int k = 0; k < 4; k++) {
                    int ny = v[0] + dy[k];
                    int nx = v[1] + dx[k];
                    if (ny < 0 || nx < 0 || ny >= n || nx >= m || map[ny][nx] == 0)
                        continue;
                    if (type[ny][nx] == 0) {
                        visit[ny][nx] = v[2] + 1;
                        type[ny][nx] = v[3];
                        deque.add(new int[] { ny, nx, v[2] + 1, v[3] });
                    } else if (type[ny][nx] == 1) {
                        if (v[3] == 2 && visit[ny][nx] == v[2] + 1) {
                            flowerCount++;
                            type[ny][nx] = 3;
                        }
                    } else if (type[ny][nx] == 2) {
                        if (v[3] == 1 && visit[ny][nx] == v[2] + 1) {
                            flowerCount++;
                            type[ny][nx] = 3;
                        }
                    }
                }
            }

            maxFlowerCount = Math.max(maxFlowerCount, flowerCount);
            return;
        }

        if (gc != greenFertilizeCount) {
            for (int i = index1; i < fertilizablePoint.size(); i++) {
                if (used[i])
                    continue;
                used[i] = true;
                greenList.add(fertilizablePoint.get(i));
                flowerCount(gc + 1, rc, i + 1, index2);
                greenList.remove(fertilizablePoint.get(i));
                used[i] = false;
            }
            return;
        }
        if (rc != redFertilizeCount)
            for (int i = index2; i < fertilizablePoint.size(); i++) {
                if (used[i])
                    continue;
                used[i] = true;
                redList.add(fertilizablePoint.get(i));
                flowerCount(gc, rc + 1, index1, i + 1);
                redList.remove(fertilizablePoint.get(i));
                used[i] = false;
            }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        greenFertilizeCount = Integer.parseInt(st.nextToken());
        redFertilizeCount = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2)
                    fertilizablePoint.add(new int[] { i, j });
            }
        }
        used = new boolean[fertilizablePoint.size()];
        flowerCount(0, 0, 0, 0);
        System.out.println(maxFlowerCount);
    }
}