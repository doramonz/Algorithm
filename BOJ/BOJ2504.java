package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Integer> stack = new Stack<>();
        boolean error = false;
        int output = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(-1);
            } else if (s.charAt(i) == '[') {
                stack.push(-2);
            } else if (s.charAt(i) == ')') {
                int sum = 0;
                if (stack.empty()) {
                    error = true;
                    break;
                }
                while (true) {
                    int v = stack.pop();
                    if (v == -1)
                        break;
                    if (v == -2 || stack.empty()) {
                        error = true;
                        break;
                    }
                    sum += v;
                }
                if (sum == 0)
                    sum = 1;
                stack.push(sum * 2);
            } else if (s.charAt(i) == ']') {
                int sum = 0;
                if (stack.empty()) {
                    error = true;
                    break;
                }
                while (true) {
                    int v = stack.pop();
                    if (v == -2)
                        break;
                    if (v == -1 || stack.empty()) {
                        error = true;
                        break;
                    }
                    sum += v;
                }
                if (sum == 0)
                    sum = 1;
                stack.push(sum * 3);
            }
            if (error)
                break;
        }
        while (!stack.empty() && !error) {
            int v = stack.pop();
            if (v == -1 || v == -2) {
                output = 0;
                break;
            }
            output += v;
        }
        System.out.println(output);
    }
}
