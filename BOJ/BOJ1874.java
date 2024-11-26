package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1874 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());
        int index = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            while (index<=arr[i]) {
                stack.add(index++);
                sb.append("+\n");
            }
            if(stack.peek()<arr[i]){
                System.out.println("NO");
                return;
            }
            stack.pop();
            sb.append("-\n");
        }
        System.out.println(sb.toString());
    }
}
