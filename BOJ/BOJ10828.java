package BOJ;

import java.io.*;
import java.util.*;

public class BOJ10828 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            switch (input.split(" ")[0]) {
                case "push":
                    stack.push(Integer.parseInt(input.split(" ")[1]));
                    break;
                case "pop":
                    if (stack.empty()) {
                        sb.append(-1 + "\n");
                    } else {
                        sb.append(stack.pop() + "\n");
                    }
                    break;
                case "size":
                    sb.append(stack.size() + "\n");
                    stack.size();
                    break;
                case "empty":
                    if (stack.empty()) {
                        sb.append(1 + "\n");
                    } else {
                        sb.append(0 + "\n");
                    }
                    break;
                case "top":
                    if (stack.empty()) {
                        sb.append(-1 + "\n");
                    } else {
                        sb.append(stack.peek() + "\n");
                    }
                    break;
            }
        }
        br.close();
        System.out.println(sb.toString());
    }
}
