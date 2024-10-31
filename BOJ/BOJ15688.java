package BOJ;

import java.io.*;
import java.util.*;

public class BOJ15688 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[2000001];
        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(br.readLine())+1000000]++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i]; j++) {
                sb.append(i-1000000 + "\n");
            }
        }
        System.out.println(sb.toString());
    }
}
