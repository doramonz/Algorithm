package BOJ;

import java.io.*;

public class BOJ10818 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(s[i]);
            if (v < min)
                min = v;
            if (v > max)
                max = v;
        }
        System.out.println(min + " " + max);
    }
}
