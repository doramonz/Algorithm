package BOJ;

import java.io.*;
import java.util.*;

public class BOJ5597 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] arr = new boolean[31];
        for (int i = 0; i < 28; i++) {
            arr[Integer.parseInt(br.readLine())] = true;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= 30; i++) {
            if (!arr[i]) {
                min = Math.min(min, i);
                max = Math.max(max, i);
            }
        }
        System.out.println(min + "\n" + max);
    }
}
