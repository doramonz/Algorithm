package SWEA;

import java.io.*;

public class SWEA2058 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int sum = 0;
        for (char c : s.toCharArray()) {
            sum += c - '0';
        }
        System.out.println(sum);
    }
}
