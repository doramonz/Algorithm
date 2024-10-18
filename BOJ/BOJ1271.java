package BOJ;

import java.io.*;
import java.math.BigInteger;

public class BOJ1271 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        BigInteger m = new BigInteger(input[0]);
        BigInteger n = new BigInteger(input[1]);
        System.out.println(m.divide(n) + "\n" + m.mod(n));
    }
}
