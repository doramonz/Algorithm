package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1715 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(br.readLine());
            queue.add(v);
        }
        while (!queue.isEmpty()) {
            Integer v1 = queue.poll();
            Integer v2 = queue.poll();
            if (v2 != null) {
                queue.add(v1 + v2);
                count += v1 + v2;
            }
        }
        System.out.println(count);
    }
}
