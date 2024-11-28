package BOJ;

import java.io.*;
import java.util.*;

public class BOJ11003 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Deque<int[]> dq = new ArrayDeque<>();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            if (i - l >= 0)
                while (!dq.isEmpty() && dq.peekFirst()[0] <= i - l) {
                    dq.poll();
                }
            while (!dq.isEmpty() && dq.peek()[1] > arr[i]) {
                dq.poll();
            }
            while (!dq.isEmpty() && dq.peekLast()[1] > arr[i]) {
                dq.pollLast();
            }
            dq.add(new int[] { i, arr[i] });
            result[i] = dq.peek()[1];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            sb.append(result[i] + " ");
        System.out.println(sb);
    }
}
