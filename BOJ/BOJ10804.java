package BOJ;

import java.io.*;
import java.util.*;

public class BOJ10804 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[21];
        for (int i = 1; i <= 20; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            for (int j = a; j <= (a + b) / 2; j++) {
                int temp = arr[j];
                arr[j] = arr[b + a - j];
                arr[b + a - j] = temp;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 20; i++) {
            sb.append(arr[i] + " ");
        }
        System.out.println(sb.toString());
    }
}
