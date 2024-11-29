package BOJ;

import java.io.*;
import java.util.*;

public class BOJ9466 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < test_case; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++)
                arr[i] = Integer.parseInt(st.nextToken());
            int sum = 0;
            int[] visit = new int[n + 1];
            int[] counts = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                if (visit[i] != 0)
                    continue;
                int count = 1;
                int current = i;
                while (visit[current] == 0) {
                    visit[current] = i;
                    counts[current] = count++;
                    current = arr[current];
                    if (visit[current] == i) {
                        sum += count - counts[current];
                    }
                }
            }
            sb.append(n - sum).append("\n");
        }
        System.out.println(sb);
    }
}
