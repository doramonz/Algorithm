package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1043 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int knowner = Integer.parseInt(st.nextToken());
        int[] knowners = new int[knowner];
        for (int i = 0; i < knowner; i++)
            knowners[i] = Integer.parseInt(st.nextToken()) - 1;

        int[][] people = new int[n][n];
        List<Integer>[] parties = new ArrayList[m];
        for (int i = 0; i < m; i++)
            parties[i] = new ArrayList<>();
        for (int k = 0; k < m; k++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            for (int i = 0; i < p; i++) {
                int v = Integer.parseInt(st.nextToken()) - 1;
                parties[k].add(v);
            }
            for (int i = 0; i < p; i++)
                for (int j = i + 1; j < p; j++) {
                    people[parties[k].get(i)][parties[k].get(j)] = 1;
                    people[parties[k].get(j)][parties[k].get(i)] = 1;
                }
        }
        boolean[] visit = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < knowner; i++) {
            visit[knowners[i]] = true;
            queue.add(knowners[i]);
            while (!queue.isEmpty()) {
                int v = queue.poll();
                for (int j = 0; j < n; j++) {
                    if (people[v][j] == 0)
                        continue;
                    if (visit[j])
                        continue;
                    visit[j] = true;
                    queue.add(j);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
            boolean flag = true;
            for (int v : parties[i]) {
                if (visit[v]) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                result++;
        }
        System.out.println(result);
    }
}
