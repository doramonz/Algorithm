package BOJ;

import java.util.*;
import java.io.*;

public class BOJ16401 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] snacks = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            snacks[i] = Integer.parseInt(st.nextToken());
        int l = 1;
        int r = Arrays.stream(snacks).max().getAsInt();
        int result = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            int count = 0;
            for (int i = 0; i < n; i++)
                count += snacks[i] / mid;
            if (count < m) {
                r = mid - 1;
            } else {
                result = mid;
                l = mid + 1;
            }
        }
        System.out.println(result);
    }
}
