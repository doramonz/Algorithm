package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        Queue<Integer> queue = new ArrayDeque<>();
        int n = Integer.parseInt(temp[0]);
        int x = Integer.parseInt(temp[1]);
        int[] map = new int[100001];
        for (int i = 0; i < map.length; i++)
            map[i] = Integer.MAX_VALUE;
        map[n] = 0;
        queue.add(n);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            if (v - 1 >= 0 && map[v] + 1 < map[v - 1]) {
                map[v - 1] = map[v] + 1;
                queue.add(v - 1);
            }
            if (v + 1 < 100001 && map[v] + 1 < map[v + 1]) {
                map[v + 1] = map[v] + 1;
                queue.add(v + 1);
            }
            if (v * 2 < 100001 && map[v] + 1 < map[v * 2]) {
                map[v * 2] = map[v] + 1;
                queue.add(v * 2);
            }
        }
        System.out.println(map[x]);
    }
}
