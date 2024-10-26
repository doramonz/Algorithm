package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2440 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = n; i >= 1; i--) {
            for (int j = i; j >= 1; j--) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
