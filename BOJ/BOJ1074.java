package BOJ;

import java.io.*;

public class BOJ1074 {

    static int func(int n, int x, int y) {
        if (n == 0) {
            return 0;
        }
        int half = 1 << (n - 1);
        if (x < half) {
            if (y < half) {
                return func(n - 1, x, y);
            } else {
                return half * half + func(n - 1, x, y - half);
            }
        } else {
            if (y < half) {
                return half * half * 2 + func(n - 1, x - half, y);
            } else {
                return half * half * 3 + func(n - 1, x - half, y - half);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int x = Integer.parseInt(temp[1]);
        int y = Integer.parseInt(temp[2]);
        System.out.println(func(n, x, y));
    }
}
