package BOJ;

import java.io.*;

public class BOJ11050 {

    static int bionimalCoefficient(int n, int k) {
        if (k == 0 || n == k)
            return 1;
        return bionimalCoefficient(n - 1, k) + bionimalCoefficient(n - 1, k - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int k = Integer.parseInt(temp[1]);
        System.out.println(bionimalCoefficient(n, k));
    }
}
