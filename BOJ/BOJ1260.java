package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1260 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        List<Integer>[] arr = new List[n + 1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = new LinkedList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u].add(v);
            arr[v].add(u);
        }
        for (int i = 1; i < arr.length; i++) {
            Collections.sort(arr[i],Collections.reverseOrder());
        }

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        boolean[] visit = new boolean[n + 1];
        stack.add(s);
        while (!stack.isEmpty()) {
            int pop = stack.pop();
            if (visit[pop])
                continue;
            sb.append(pop + " ");
            visit[pop] = true;
            for (int i = 0; i < arr[pop].size(); i++) {
                stack.add(arr[pop].get(i));
            }
        }
        sb.append("\n");
        for (int i = 1; i < arr.length; i++) {
            Collections.sort(arr[i]);
        }
        Queue<Integer> queue = new LinkedList<>();
        visit = new boolean[n + 1];
        queue.add(s);
        visit[s] = true;
        sb.append(s + " ");
        while (!queue.isEmpty()) {
            int p = queue.poll();
            for (int i = 0; i < arr[p].size(); i++) {
                int next = arr[p].get(i);
                if (visit[next])
                    continue;
                visit[next] = true;
                sb.append(next + " ");
                queue.add(next);
            }
        }
        System.out.println(sb.toString());
    }
}
