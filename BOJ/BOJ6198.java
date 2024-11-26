package BOJ;

import java.io.*;
import java.util.*;

public class BOJ6198 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(br.readLine());
            while (!stack.isEmpty() && stack.peek() <= v) {
                stack.pop();
            }
            result += stack.size();
            stack.add(v);
        }
        System.out.println(result);
    }
}
