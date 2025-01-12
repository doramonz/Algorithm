package BOJ;

import java.util.*;
import java.io.*;

public class BOJ2193 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] one = new long[n];
        long[] zero = new long[n];
        one[0] = 1;
        for (int i = 1; i < n; i++) {
            zero[i] = one[i - 1] + zero[i - 1];
            one[i] = zero[i - 1];
        }
        System.out.println(zero[n-1]+one[n-1]);
    }
}
