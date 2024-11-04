package BOJ;

import java.io.*;
import java.util.*;

public class BOJ11725 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer>[] arr = new List[n + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new LinkedList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        int[] p = new int[n + 1];
        while (!queue.isEmpty()) {
            int c = queue.poll();
            for (int i = 0; i < arr[c].size(); i++) {
                int next = arr[c].get(i);
                if (p[c] == next)
                    continue;
                p[next] = c;
                queue.add(next);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < arr.length; i++) {
            sb.append(p[i]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
