package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1568 {
    public static void main(String[] args) throws Exception {
        Integer n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int i = 1;
        int count = 0;
        while (n > 0) {
            n -= i++;
            count++;
            if (n < i)
                i = 1;
        }
        System.out.println(count);
    }
}
