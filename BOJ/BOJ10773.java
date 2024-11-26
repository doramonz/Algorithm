package BOJ;

import java.io.*;
import java.util.*;

public class BOJ10773 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(br.readLine());
            if (v == 0) {
                stack.pop();
                continue;
            }
            stack.add(v);
        }
        int sum = 0;
        while (!stack.isEmpty()) 
            sum += stack.pop();
        System.out.println(sum);
    }
}
