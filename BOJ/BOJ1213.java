package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1213 {
    public static void main(String[] args) throws Exception {
        String s = new BufferedReader(new InputStreamReader(System.in)).readLine();
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++)
            arr[s.charAt(i) - 65]++;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < arr[i] / 2; j++) {
                sb.append((char) (i + 65));
            }
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] % 2 == 1) {
                sb.append((char) (i + 65));
                break;
            }
        }
        for (int i = 25; i >= 0; i--) {
            for (int j = arr[i] / 2; j > 0; j--) {
                sb.append((char) (i + 65));
            }
        }
        if (sb.length() != s.length()) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }
        System.out.println(sb.toString());
    }
}
