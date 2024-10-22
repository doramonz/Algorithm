package BOJ;

import java.io.*;

public class BOJ10810 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int[] arr = new int[n];

        for (int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            for (int j = Integer.parseInt(s[0]) - 1; j < Integer.parseInt(s[1]); j++) {
                arr[j] = Integer.parseInt(s[2]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i] + " ");
        }
        System.out.println(sb.toString());
    }
}
