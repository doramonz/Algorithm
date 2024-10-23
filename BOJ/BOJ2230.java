package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int i = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        while (i < n && j < n) {
            if (arr[j] - arr[i] < m) {
                j++;
            } else {
                min = Math.min(arr[j] - arr[i], min);
                i++;
            }
        }
        System.out.println(min);
    }
}
