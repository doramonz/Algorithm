package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2023 {
    static int size = 1;
    static List<Integer> result = new ArrayList<>();

    static boolean isPrime(int v) {
        if (v == 1) {
            return false;
        }
        for (int i = 2; i * i <= v; i++) {
            if (v % i == 0)
                return false;
        }
        return true;
    }

    static void recur(int v) {
        if (v / size > 0) {
            if (isPrime(v)) {
                result.add(v);
            }
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (isPrime(v)) {
                recur(v * 10 + i);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i < n; i++)
            size *= 10;
        for (int i = 1; i < 10; i++)
            recur(i);
        Collections.sort(result);
        StringBuilder sb = new StringBuilder();
        for (int v : result)
            sb.append(v).append("\n");
        System.out.println(sb);
    }
}
