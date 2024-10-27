package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2445 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++)
                sb.append("*");
            for (int j = 0; j < (n - i - 1) * 2; j++)
                sb.append(" ");
            for (int j = 0; j < i + 1; j++)
                sb.append("*");
            sb.append("\n");
        }
        for (int i = n-2; i >= 0; i--) {
            for (int j = 0; j < i + 1; j++)
                sb.append("*");
            for (int j = 0; j < (n - i - 1) * 2; j++)
                sb.append(" ");
            for (int j = 0; j < i + 1; j++)
                sb.append("*");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
