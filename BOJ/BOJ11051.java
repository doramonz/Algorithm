package BOJ;

import java.io.*;

public class BOJ11051 {
    static int[][] cache = new int[1001][1001];

    static int bionimalCoefficient(int n, int k) {
        if (k == 0 || n == k)
            return 1;
        if (k > n / 2) {
            k = n - k;
        }
        if (cache[n][k] != 0) {
            return cache[n][k];
        }
        int value = (bionimalCoefficient(n - 1, k) + bionimalCoefficient(n - 1, k - 1)) % 10007;
        cache[n][k] = value;
        return value;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int k = Integer.parseInt(temp[1]);
        System.out.println(bionimalCoefficient(n, k));
    }
}
