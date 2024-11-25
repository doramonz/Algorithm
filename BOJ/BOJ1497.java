package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1497 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] guitars = new long[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            String guitar = st.nextToken();
            long sum = 0;
            for (int j = 0; j < m; j++) {
                if (guitar.charAt(j) == 'Y') {
                    sum += 1 << m - j - 1;
                }
            }
            guitars[i] = sum;
        }
        long max = 0;
        int count = 0;
        for (long i = 1; i < 1 << n; i++) {
            int c = 0;
            int v = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    c++;
                    v |= guitars[j];
                }
            }
            long vc = Long.bitCount(v);
            if (vc > max) {
                max = vc;
                count = c;
            } else if (max == vc && c < count) {
                count = c;
            }
        }
        System.out.println(max==0?-1:count);
    }
}
