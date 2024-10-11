package BOJ;

import java.util.*;
import java.io.*;

public class BOJ4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();
            if (input.charAt(0) == '.' && input.length() == 1)
                break;
            Stack<Character> stack = new Stack<>();
            boolean flag = false;
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                switch (c) {
                    case '(':
                        stack.push('(');
                        break;
                    case ')':
                        if (stack.size() == 0 || stack.pop() != '(')
                            flag = true;
                        break;
                    case '{':
                        stack.push('{');
                        break;
                    case '}':
                        if (stack.size() == 0 || stack.pop() != '{')
                            flag = true;
                        break;
                    case '[':
                        stack.push('[');
                        break;
                    case ']':
                        if (stack.size() == 0 || stack.pop() != '[') {
                            flag = true;
                        }
                        break;
                }
                if (flag)
                    break;
            }
            if (flag || stack.size() > 0) {
                sb.append("no" + "\n");
            } else {
                sb.append("yes" + "\n");
            }
        }

        System.out.println(sb.toString());
    }
}
