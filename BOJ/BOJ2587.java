package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2587 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[5];
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            int n = Integer.parseInt(br.readLine());
            sum += n;
            arr[i] = n;
        }
        Arrays.sort(arr);
        System.out.println(sum / 5 + "\n" + arr[2]);
    }
}
