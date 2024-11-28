package BOJ;

import java.io.*;
import java.util.*;

public class BOJ6593 {
    static int[] dz = { 1, -1, 0, 0, 0, 0 };
    static int[] dx = { 0, 0, 1, 0, -1, 0 };
    static int[] dy = { 0, 0, 0, 1, 0, -1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (l == 0)
                break;

            Queue<int[]> queue = new ArrayDeque<>();
            boolean[][][] map = new boolean[l][r][c];
            int[] exit = null;
            int count = -1;
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    String s = br.readLine();
                    for (int k = 0; k < c; k++) {
                        if (s.charAt(k) == 'S') {
                            map[i][j][k] = true;
                            queue.add(new int[] { i, j, k, 0 });
                        } else if (s.charAt(k) == 'E') {
                            exit = new int[] { i, j, k };
                        } else if (s.charAt(k) == '#') {
                            map[i][j][k] = true;
                        }
                    }
                }
                br.readLine();
            }
            while (!queue.isEmpty()) {
                int[] v = queue.poll();
                if (v[0] == exit[0] && v[1] == exit[1] && v[2] == exit[2]) {
                    count = v[3];
                    break;
                }
                for (int k = 0; k < 6; k++) {
                    int nz = v[0] + dz[k];
                    int ny = v[1] + dy[k];
                    int nx = v[2] + dx[k];
                    if (nz < 0 || ny < 0 || nx < 0 || nz >= l || ny >= r || nx >= c)
                        continue;
                    if (map[nz][ny][nx])
                        continue;
                    map[nz][ny][nx] = true;
                    queue.add(new int[] { nz, ny, nx, v[3] + 1 });
                }
            }
            if (count != -1) {
                sb.append("Escaped in " + count + " minute(s).");
            } else {
                sb.append("Trapped!");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
