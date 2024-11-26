package BOJ;

import java.io.*;
import java.util.*;

public class BOJ17298 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<int[]> stack = new Stack<>();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty() && stack.peek()[1] < v) {
                result[stack.pop()[0]] = v;
            }
            stack.add(new int[] { i, v });
        }
        while (!stack.isEmpty()) {
            result[stack.pop()[0]] = -1;
        }
        StringBuilder sb = new StringBuilder();
        Arrays.stream(result).forEach(x -> {
            sb.append(x+" ");
        });
        System.out.println(sb);
    }
}
