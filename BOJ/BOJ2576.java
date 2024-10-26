package BOJ;

import java.io.*;

public class BOJ2576 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < 7; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n % 2 == 1) {
                if (n < min)
                    min = n;
                sum += n;

            }
        }
        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum + "\n" + min);
        }
    }
}
