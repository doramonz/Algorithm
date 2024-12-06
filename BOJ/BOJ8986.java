package BOJ;

import java.io.*;
import java.util.*;

public class BOJ8986 {
    static long function(int[] arr, long x) {
        long sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += Math.abs(arr[i] - x * i);
        return sum;
    }

    static long search(int[] arr) {
        long left = 0;
        long right = arr[arr.length - 1];
        while (left + 2 < right) {
            long mid1 = (right + left * 2) / 3;
            long mid2 = (right * 2 + left) / 3;
            if (function(arr, mid1) <= function(arr, mid2)) {
                right = mid2;
            } else {
                left = mid1;
            }
        }
        long min = Long.MAX_VALUE;
        for(long i = left;i<=right;i++)
            min = Math.min(min, function(arr, i));

        return min;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        System.out.println(search(arr));
    }
}
