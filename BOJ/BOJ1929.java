package BOJ;

import java.io.*;

public class BOJ1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);
        boolean[] aris = new boolean[1000001];
        aris[1] = true;
        for (int i = 2; i * i < aris.length; i++) {
            if (aris[i])
                continue;
            for (int j = i * i; j < aris.length; j += i) {
                aris[j] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = n; i <= m; i++) {
            if (!aris[i])
                sb.append(i + "\n");
        }
        System.out.println(sb.toString());
    }
}
