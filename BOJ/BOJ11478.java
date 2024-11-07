package BOJ;

import java.io.*;
import java.util.*;

public class BOJ11478 {
    public static void main(String[] args) throws Exception {
        String s = new BufferedReader(new InputStreamReader(System.in)).readLine();
        TreeSet<String> treeSet = new TreeSet<>();
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < s.length() - i + 1; j++) {
                treeSet.add(s.substring(j, j + i));
            }
        }
        System.out.println(treeSet.size());
    }
}
