package BOJ;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class BOJ10093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger a = new BigInteger(st.nextToken());
        BigInteger b = new BigInteger(st.nextToken());
        StringBuilder sb = new StringBuilder();
        if (a.compareTo(b) < 0) {
            sb.append(b.subtract(a).subtract(new BigInteger("1")) + "\n");
            a = a.add(new BigInteger("1"));
            while (a.compareTo(b) < 0) {
                sb.append(a + " ");
                a = a.add(new BigInteger("1"));
            }
        } else if (a.compareTo(b) == 0) {
            sb.append(0);
        } else {
            sb.append(a.subtract(b).subtract(new BigInteger("1")) + "\n");
            b = b.add(new BigInteger("1"));
            while (b.compareTo(a) < 0) {
                sb.append(b + " ");
                b = b.add(new BigInteger("1"));
            }
        }
        System.out.println(sb.toString());
    }
}
