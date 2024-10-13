package BOJ;

import java.io.*;

public class BOJ11729 {

    static StringBuilder sb = new StringBuilder();
    static int n = 0;

    static void hanoi(int i, int from, int to, int mid) {
        if (i == 1) {
            sb.append(from + " " + to + "\n");
            n++;
            return;
        }
        hanoi(i - 1, from, mid, to);
        sb.append(from + " " + to + "\n");
        n++;
        hanoi(i - 1, mid, to, from);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(br.readLine());
        hanoi(i, 1, 3, 2);
        System.out.println(n + "\n" + sb.toString());
    }
}
