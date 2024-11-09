package SWEA;

import java.io.*;
import java.util.*;

public class SWEA1926 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            int count = 0;
            String s = String.valueOf(i);
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '3' || s.charAt(j) == '6' || s.charAt(j) == '9')
                    count++;
            }
            if (count == 0) {
                sb.append(i + " ");
            } else {
                for (int j = 0; j < count; j++)
                    sb.append("-");
                sb.append(" ");
            }
        }
        System.out.println(sb);
    }
}
