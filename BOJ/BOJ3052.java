package BOJ;

import java.io.*;
import java.util.*;

public class BOJ3052 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] arr = new boolean[42];
        for (int i = 0; i < 10; i++) {
            arr[Integer.parseInt(br.readLine())%42] = true;
        }
        int count = 0;
        for (int i = 0; i < 42; i++) {
            if (arr[i])
                count++;
        }
        System.out.println(count);
    }
}
