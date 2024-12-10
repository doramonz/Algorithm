package BOJ;

import java.io.*;
import java.util.*;

public class BOJ15665 {
    static int n;
    static int m;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    static void recur(int count, String s, int index) {
        if (count == m) {
            sb.append(s).append("\n");
            return;
        }
        int lastUsed = -1;
        for (int i = index; i < n; i++) {
            if (arr[i] == lastUsed)
                continue;
            recur(count + 1, s + arr[i] + " ", i);
            lastUsed = arr[i];
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
        recur(0, "", 0);
        System.out.println(sb);
    }
}
