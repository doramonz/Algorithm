package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1543 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String find = scanner.nextLine();
        scanner.close();
        int result = 0;
        int s = 0;
        while (true) {
            s = str.indexOf(find, s);
            if (s == -1)
                break;
            s += find.length();
            result++;
        }
        System.out.println(result);
    }
}
