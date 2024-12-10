package BOJ;

import java.io.*;
import java.util.*;

public class BOJ15651 {
    static int n;
    static int m;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    static void recur(int c) {
        if (c == m) {
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            arr[c] = i;
            recur(c + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        recur(0);
        System.out.println(sb);
    }
}
