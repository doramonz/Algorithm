package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1316 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            int[] arr = new int[26];
            String s = br.readLine();
            arr[s.charAt(0) % 26]++;
            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(j - 1) != s.charAt(j) && arr[s.charAt(j) % 26] > 0) {
                    flag = true;
                    break;
                }
                arr[s.charAt(j)%26]++;
            }
            if (!flag)
                count++;
        }
        System.out.println(count);
    }
}
