package BOJ;

import java.io.*;
import java.util.*;

public class BOJ9013 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            Stack<Character> stack = new Stack<>();
            String input = br.readLine();
            boolean skip = false;
            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == '(') {
                    stack.push(input.charAt(j));
                } else {
                    if (stack.isEmpty()) {
                        skip=true;
                        sb.append("NO\n");
                        break;
                    }
                    stack.pop();
                }
            }
            if (skip)
                continue;
            if (stack.isEmpty())
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }
        System.out.println(sb.toString());
    }
}
