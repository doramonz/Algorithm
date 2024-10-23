package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] cable = new int[n];
        for (int i = 0; i < n; i++) {
            cable[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(cable);
        long left = 0;
        long right = cable[cable.length - 1];
        long value = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            long sum_cable = 0;
            for (int i = 0; i < cable.length; i++) {
                sum_cable += cable[i] / mid;
            }
            if (sum_cable >= m) {
                value = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(value);
    }
}
