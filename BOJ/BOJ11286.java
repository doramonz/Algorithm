package BOJ;

import java.io.*;
import java.util.*;

public class BOJ11286 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) == Math.abs(o2) && !o1.equals(o2)) {
                    if (o1 < o2)
                        return -1;
                    return 1;
                }
                if (o1.equals(o2))
                    return 0;
                return Math.abs(o1) < Math.abs(o2) ? -1 : 1;
            }

        });
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(br.readLine());
            if (v == 0) {
                Integer poll = queue.poll();
                if (poll == null)
                    poll = 0;
                sb.append(poll + "\n");
                continue;
            }
            queue.add(v);
        }
        System.out.println(sb.toString());
    }
}
