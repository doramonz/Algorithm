package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1267 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = 0;
        int m = 0;
        for (int i = 0; i < n; i++) {
            int t = Integer.parseInt(st.nextToken());
            y += t / 30*10 + 10;
            m += t / 60*15 + 15;
        }
        if (y > m) {
            System.out.println("M " + m);
        } else if (y == m) {
            System.out.println("Y M " + y);
        } else {
            System.out.println("Y " + y);
        }
    }
}
