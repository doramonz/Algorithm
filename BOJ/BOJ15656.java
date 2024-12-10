package BOJ;

import java.io.*;
import java.util.*;

public class BOJ15656 {
    static int n;
    static int m;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    static void recur(int count, String s) {
        if (count == m) {
            sb.append(s).append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            recur(count + 1, s + arr[i] + " ");
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        recur(0, "");
        System.out.println(sb);
    }
}
