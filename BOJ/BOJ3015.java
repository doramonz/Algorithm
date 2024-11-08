package BOJ;

import java.io.*;
import java.util.*;

public class BOJ3015 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][1] = 1;
            arr[i][0] = Integer.parseInt(br.readLine());
        }
        Stack<int[]> stack = new Stack<>();
        long cnt = 0;
        int i = 0;
        while (i < n) {
            if (stack.isEmpty()) {
                stack.add(arr[i]);
                i++;
            } else if (stack.peek()[0] == arr[i][0]) {
                arr[i] = stack.pop();
                cnt += arr[i][1];
                arr[i][1]++;
            } else if (stack.peek()[0] > arr[i][0]) {
                stack.add(arr[i]);
                cnt++;
                i++;
            } else {
                cnt += stack.pop()[1];
            }
        }

        System.out.println(cnt);
    }
}
