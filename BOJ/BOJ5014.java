package BOJ;

import java.io.*;
import java.util.*;

public class BOJ5014 {
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        boolean[] visit = new boolean[f + 1];
        Queue<int[]> queue = new ArrayDeque<>();
        visit[s] = true;
        int result = -1;
        queue.add(new int[] { s, 0 });
        while (!queue.isEmpty()) {
            int[] v = queue.poll();
            if (v[0] == g) {
                result = v[1];
                break;
            }
            if (v[0] + u <= f && !visit[v[0] + u]) {
                visit[v[0] + u] = true;
                queue.add(new int[] { v[0] + u, v[1] + 1 });
            }
            if (v[0] - d >= 1 && !visit[v[0] - d]) {
                visit[v[0] - d] = true;
                queue.add(new int[] { v[0] - d, v[1] + 1 });
            }
        }
        if (result != -1) {
            System.out.println(result);
        } else {
            System.out.println("use the stairs");
        }
    }
}
