package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1722 {
    static boolean[] used;
    static long[] fact;

    static void func1(int n, long k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int f = n - i - 1;
            for (int j = 1; j <= n; j++) {
                if (used[j])
                    continue;
                if (k <= fact[f]) {
                    sb.append(j + " ");
                    used[j] = true;
                    break;
                } else {
                    k -= fact[f];
                }
            }
        }
        System.out.println(sb.toString());
    }

    static void func2(int n, int[] k) {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 1; j < k[i]; j++) {
                if (!used[j])
                    count++;
            }
            used[k[i]] = true;
            sum += fact[n - i - 1] * count;
        }
        System.out.println(++sum);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        used = new boolean[n + 1];
        fact = new long[n + 1];
        fact[0] = 1;
        fact[1] = 1;
        for (int i = 2; i <= n; i++) {
            fact[i] = fact[i - 1] * i;
        }
        String temp = br.readLine();
        if (temp.charAt(0) == '1') {
            long target = Long.parseLong(temp.split(" ")[1]);
            func1(n, target);
        } else {
            String[] temps = temp.split(" ");
            int[] comp = new int[n];
            for (int i = 1; i < temps.length; i++) {
                comp[i - 1] = Integer.parseInt(temps[i]);
            }
            func2(n, comp);
        }
    }
}
