package BOJ;

import java.io.*;
import java.util.*;

public class BOJ11724 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer>[] list = new List[n + 1];
        for (int i = 1; i < list.length; i++) {
            list[i] = new LinkedList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }
        int count = 0;

        boolean[] visit = new boolean[n + 1];
        for (int i = 1; i < list.length; i++) {
            if (visit[i])
                continue;
            count++;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            visit[i] = true;
            while (!queue.isEmpty()) {
                int next = queue.poll();
                for (int j = 0; j < list[next].size(); j++) {
                    if (visit[list[next].get(j)])
                        continue;
                    visit[list[next].get(j)] = true;
                    queue.add(list[next].get(j));
                }
            }
        }
        System.out.println(count);
    }
}
