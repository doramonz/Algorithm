package BOJ;

import java.util.*;
import java.io.*;

public class BOJ18869 {
    public static void main(String[] args) throws Exception {
        int result = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            int[] sorted = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                sorted[j] = arr[j];
            }
            Arrays.sort(sorted);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                int l = 0;
                int r = n;
                while (l <= r) {
                    int mid = (l + r) / 2;
                    if (sorted[mid] >= arr[j]) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
                arr[j] = r;
            }
            for (int k = 0; k < n; k++)
                sb.append(arr[k]);

            result += map.getOrDefault(sb.toString(), 0);
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
        }
        System.out.println(result);
    }
}
