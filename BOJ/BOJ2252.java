package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2252 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);
        List<Integer>[] list = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++)
            list[i] = new LinkedList<>();
        int[] degree = new int[n + 1];
        int[] result = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            temp = br.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            degree[b]++;
            list[a].add(b);
        }
        Queue<Integer> queue = new ArrayDeque();
        for (int i = 1; i <= n; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }
        for (int i = 1; i <= n; i++) {
            int x = queue.poll();
            result[i] = x;
            for (int j = 0; j < list[x].size(); j++) {
                int y = list[x].get(j);
                if (--degree[y] == 0)
                    queue.add(y);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1;i<=n;i++){
            sb.append(result[i]+" ");
        }
        System.out.println(sb.toString());
    }
}
