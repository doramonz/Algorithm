package BOJ;

import java.io.*;
import java.util.*;

public class BOJ17413 {
    public static void main(String[] args) throws Exception {
        String s = new BufferedReader(new InputStreamReader(System.in)).readLine();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < s.length()) {
            if (s.charAt(i) == '<') {
                while (true) {
                    sb.append(s.charAt(i));
                    i++;
                    if(s.charAt(i-1)=='>')
                        break;
                }
            } else if (s.charAt(i) == ' ') {
                sb.append(' ');
                i++;
            } else {
                int j = i;
                while (i < s.length() && s.charAt(i) != '<'&&s.charAt(i)!=' ') {
                    i++;
                }
                for (int k = i - 1; k >= j; k--) {
                    sb.append(s.charAt(k));
                }
            }
        }
        System.out.println(sb.toString());
    }
}
