package BOJ;

import java.io.*;

public class BOJ1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int a = Integer.parseInt(temp[0]);
        int b = Integer.parseInt(temp[1]);
        int c = Integer.parseInt(temp[2]);

        System.out.println(pow(a, b, c));
    }

    static long pow(int a, int b, int c) {
        if (b == 0)
            return 1;
        long half = pow(a, b / 2, c) % c;
        long result = half * half % c;
        if (b % 2 != 0) {
            result = result * a % c;
        }
        return result;
    }
}
