package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int result = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            while (sum >= s && start < arr.length) {
                result = Math.min(i - start + 1, result);
                sum -= arr[start];
                start++;
            }
        }
        if (result == Integer.MAX_VALUE)
            result = 0;
        System.out.println(result);
    }
}
