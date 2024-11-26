package BOJ;

import java.io.*;
import java.util.*;

public class BOJ3015 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<int[]> stack = new Stack<>();
        long cnt = 0;
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(br.readLine());
            int h = 1;
            while (!stack.isEmpty() && stack.peek()[0] <= v) {
                int[] pop = stack.pop();
                cnt += pop[1];
                if (pop[0] == v)
                    h += pop[1];
            }
            stack.add(new int[] { v, h });
            if (!stack.isEmpty() && stack.size() > 1)
                cnt++;
        }
        System.out.println(cnt);
    }
}
