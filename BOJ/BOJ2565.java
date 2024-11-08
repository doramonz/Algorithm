package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2565 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (x, y) -> {
            return x[0] - y[0];
        });
        int[] size = new int[n];
        for (int i = 0; i < n; i++) {
            size[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j][1] < arr[i][1]) {
                    size[i] = Math.max(size[i], size[j] + 1);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < size.length; i++)
            max = Math.max(max, size[i]);
        System.out.println(n-max);
    }
}
