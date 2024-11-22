package BOJ;

import java.io.*;
import java.util.*;

public class BOJ16916 {
    static boolean kmp(String s1, String s2) {
        int[] p = new int[s2.length()];
        int j = 0;
        for (int i = 1; i < s2.length(); i++) {
            while (j > 0 && s2.charAt(i) != s2.charAt(j)) {
                j = p[j - 1];
            }
            if (s2.charAt(i) == s2.charAt(j)) {
                p[i] = ++j;
            }
        }
        j = 0;
        for (int i = 0; i < s1.length(); i++) {
            while (j > 0 && s1.charAt(i) != s2.charAt(j)) {
                j = p[j - 1];
            }
            if (s1.charAt(i) == s2.charAt(j)) {
                if (j == s2.length() - 1) {
                    return true;
                }
                j++;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        System.out.println(kmp(s1, s2) ? 1 : 0);
    }
}
