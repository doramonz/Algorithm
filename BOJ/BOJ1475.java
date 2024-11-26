package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1475 {
    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int[] arr = new int[10];
        while (n > 0) {
            arr[n % 10]++;
            n /= 10;
        }
        arr[6] = (arr[6] + arr[9]) / 2 + (arr[6] + arr[9]) % 2;
        arr[9] = 0;
        int max = 0;
        for (int i = 0; i < 10; i++)
            max = Math.max(max, arr[i]);
        System.out.println(max);
    }
}
