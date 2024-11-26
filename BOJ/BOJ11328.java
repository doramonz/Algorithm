package BOJ;

import java.io.*;
import java.util.*;

public class BOJ11328 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < c; i++) {
            int[] arr = new int[26];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (char s : st.nextToken().toCharArray()) {
                arr[s - 'a']++;
            }
            boolean flag = false;
            for (char s : st.nextToken().toCharArray()) {
                arr[s - 'a']--;
            }
            for (int ii : arr)
                if (ii != 0)
                    flag = true;
            if (flag) {
                sb.append("Impossible").append("\n");
            } else {
                sb.append("Possible").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
