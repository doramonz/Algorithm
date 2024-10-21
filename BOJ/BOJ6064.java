package BOJ;

import java.io.*;

public class BOJ6064 {

    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int time = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < time; i++) {
            int result = -1;
            String[] temp = br.readLine().split(" ");
            int n = Integer.parseInt(temp[0]);
            int m = Integer.parseInt(temp[1]);
            int x = Integer.parseInt(temp[2]) - 1;
            int y = Integer.parseInt(temp[3]) - 1;

            int l = lcm(n, m);
            for (int j = x; j < l; j += n) {
                if (j % m == y) {
                    result = j + 1;
                    break;
                }
            }
            sb.append(result + "\n");

        }
        System.out.println(sb.toString());
    }
}
