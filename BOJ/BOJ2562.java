package BOJ;

import java.io.*;

public class BOJ2562 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0, index = 0;
        for (int i = 1; i <= 9; i++) {
            int v = Integer.parseInt(br.readLine());
            if (v > max) {
                max = v;
                index = i;
            }
        }
        System.out.println(max + "\n" + index);
    }
}
