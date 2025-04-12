package BOJ;

import java.util.*;
import java.io.*;

public class BOJ2473 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int i = 0;
        int j = n - 1;
        int result = Integer.MAX_VALUE;
        while (i < j - 1) {
            int left = i;
            int right = j;
            int sum = arr[left] + arr[result];
            while (left<right) {
                int mid = (left+right)/2;
            }
        }
    }
}
