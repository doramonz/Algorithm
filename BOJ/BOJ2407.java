package BOJ;

import java.io.*;
import java.math.BigInteger;

public class BOJ2407 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);

        BigInteger sum = new BigInteger("1");
        for (int i = n; i > n - m; i--) {
            sum = sum.multiply(new BigInteger(String.valueOf(i)));
        }
        BigInteger div = new BigInteger("1");
        for(int i = 1;i<=m;i++){
            div = div.multiply(new BigInteger(String.valueOf(i)));
        }
        System.out.println(sum.divide(div));
    }
}
