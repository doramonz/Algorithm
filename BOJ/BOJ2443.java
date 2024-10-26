package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2443 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i - 1; j++)
                sb.append(" ");
            for (int j = 0; j < i * 2 + 1; j++)
                sb.append("*");
            sb.append("\n");
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++)
                sb.append(" ");
            for (int j = 0; j < (n - i) * 2 - 1; j++)
                sb.append("*");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
