package BOJ;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class BOJ1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            BigInteger result = new BigInteger("1");
            for (int j = b; j > b - a; j--) {
                result = result.multiply(new BigInteger(String.valueOf(j)));
            }
            for (int j = 1; j <= a; j++) {
                result = result.divide(new BigInteger(String.valueOf(j)));
            }
            sb.append(result + "\n");
        }
        System.out.println(sb.toString());
    }
}
