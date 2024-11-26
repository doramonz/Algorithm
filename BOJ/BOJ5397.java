package BOJ;

import java.io.*;
import java.util.*;

public class BOJ5397 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            Stack<String> left = new Stack<>();
            Stack<String> right = new Stack<>();
            String s = br.readLine();
            for (char c : s.toCharArray()) {
                if (c == '<') {
                    if (!left.isEmpty()) {
                        right.add(left.pop());
                    }
                } else if (c == '>') {
                    if (!right.isEmpty()) {
                        left.add(right.pop());
                    }
                } else if (c == '-') {
                    if (!left.isEmpty()) {
                        left.pop();
                    }
                } else {
                    left.add(String.valueOf(c));
                }
            }
            while (!left.isEmpty()) {
                right.add(left.pop());
            }
            while (!right.isEmpty()) {
                sb.append(right.pop());
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
