package BOJ;

import java.io.*;
import java.util.*;

public class BOJ3986 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i = 0; i < n; i++) {
            Stack<Character> stack = new Stack<>();
            String input = br.readLine();
            for (char c : input.toCharArray()) {
                if (!stack.isEmpty()&&stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.add(c);
                }
            }
            if(stack.size()==0)
            result++;
        }
        System.out.println(result);
    }
}
