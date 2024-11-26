package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1919 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        int[] arr = new int[26];
        for (char c : a.toCharArray())
            arr[c - 'a']++;
        int result = 0;
        for (char c : b.toCharArray())
            arr[c - 'a']--;
        for (int i = 0; i < 26; i++)
            result += Math.abs(arr[i]);
        System.out.println(result);
    }
}
