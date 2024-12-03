package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1932 {
    static int n;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[i + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < n; i++) {
            arr[i][0] = arr[i - 1][0] + arr[i][0];
            for (int j = 1; j < i; j++) {
                arr[i][j] = Math.max(arr[i - 1][j - 1], arr[i - 1][j]) + arr[i][j];
            }
            arr[i][i] = arr[i - 1][i-1] + arr[i][i];
        }

        int max = 0;
        for(int i = 0;i<n;i++){
            max = Math.max(max, arr[n-1][i]);
        }
        System.out.println(max);
    }
}
