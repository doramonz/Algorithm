package BOJ;

import java.io.*;
import java.util.*;

public class BOJ18870 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n];
        int[] sorted = new int[n];
        int[] result = new int[n];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(s[i]);
            sorted[i] = input[i];
        }
        Arrays.sort(sorted);
        sorted = Arrays.stream(sorted).distinct().toArray();
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = sorted.length;
            while (left < right) {
                int mid = (left + right) / 2;
                if (input[i] <= sorted[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            result[i] = left;
        }
        StringBuilder sb = new StringBuilder();
        Arrays.stream(result).forEach(x -> sb.append(x+" "));
        System.out.println(sb.toString());
    }
}
