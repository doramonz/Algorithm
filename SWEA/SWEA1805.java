package SWEA;

import java.io.*;
import java.util.*;

public class SWEA1805 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nums = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int k = 1; k <= nums; k++) {
            sb.append("#" + k + " ");
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                String s = br.readLine();
                for (int j = 0; j < n; j++) {
                    arr[i][j] = s.charAt(j) - '0';
                }
            }
            int sum = 0;
            int center = n / 2;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (Math.abs(center - i) + Math.abs(center - j) <= center)
                        sum += arr[i][j];
                }
            }
            sb.append(sum + "\n");
        }
        System.out.println(sb);
    }
}
