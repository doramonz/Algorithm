package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2493 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<int[]> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty() && stack.peek()[1] < v) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                stack.add(new int[] { i, v });
                sb.append("0 ");
            }else if(stack.peek()[1]==v){
                sb.append(stack.pop()[0]+1+" ");
                stack.add(new int[]{i,v});
            }else{
                sb.append(stack.peek()[0]+1+" ");
                stack.add(new int[]{i,v});
            }
        }
        System.out.println(sb.toString());
    }
}
