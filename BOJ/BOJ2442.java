package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2442 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = n - i; j > 0; j--) {
                sb.append(" ");
            }
            for (int j = 0; j < (i-1)*2+1; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
