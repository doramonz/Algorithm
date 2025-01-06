package BOJ;

import java.util.*;
import java.io.*;

public class BOJ2805 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] trees = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            trees[i] = Integer.parseInt(st.nextToken());
        int l = 0;
        int r = Arrays.stream(trees).max().getAsInt();
        while (l <= r) {
            int mid = (l + r) / 2;
            long count = 0;
            for (int i = 0; i < n; i++)
                count += (trees[i] - mid <= 0 ? 0 : trees[i] - mid);
            if (count < m) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(r);
    }
}
