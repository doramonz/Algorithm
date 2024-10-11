package BOJ;

import java.io.*;
import java.util.*;

public class BOJ10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String bracket = br.readLine();
        Stack<Character> stack = new Stack<>();
        int output = 0;
        for (int i = 0; i < bracket.length(); i++) {
            if (bracket.charAt(i) == '(') {
                stack.push('(');
            } else {
                if (bracket.charAt(i) == ')' && bracket.charAt(i - 1) == '(') {
                    stack.pop();
                    output += stack.size();
                } else {
                    stack.pop();
                    output++;
                }
            }
        }
        System.out.println(output);
    }

}
