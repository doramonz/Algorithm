package BOJ;

import java.io.*;
import java.util.*;

public class BOJ9663 {
    static int[] map;
    static int count;

    static void queen(int n, int index) {
        if (n == index) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            boolean flag = true;

            for (int j = index - 1; j >= 0; j--) {
                if (i == map[j] || Math.abs(map[j] - i) == Math.abs(index - j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                map[index] = i;
                queen(n, index + 1);
            }
        }

    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n];
        count = 0;
        queen(n, 0);
        System.out.println(count);
    }
}
