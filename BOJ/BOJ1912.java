package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1912 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < n; i++) {
            arr[i] = Math.max(arr[i - 1] + arr[i], arr[i]);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
            max = Math.max(max, arr[i]);
        System.out.println(max);
    }
}
