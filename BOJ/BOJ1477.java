package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1477 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] rest = new int[n + 2];
        st = new StringTokenizer(br.readLine());
        rest[0] = 0;
        for (int i = 1; i <= n; i++)
            rest[i] = Integer.parseInt(st.nextToken());
        rest[n + 1] = l;
        Arrays.sort(rest);

        int i = 1;
        int r = l;
        int result = 0;
        while (i <= r) {
            int mid = (i + r) / 2;
            int d = 0;
            for (int k = 1; k < rest.length; k++)
                d += (rest[k] - rest[k - 1] - 1) / mid;
            if (d > m) {
                i = mid + 1;
            } else {
                result = mid;
                r = mid - 1;
            }
        }
        System.out.println(result);
    }

}
