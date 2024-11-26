package BOJ;

import java.io.*;
import java.util.*;

public class BOJ3273 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new TreeSet<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        int x = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i : set) {
            if (x - i == i)
                continue;
            if (set.contains(x - i))
                result++;
        }
        System.out.println(result/2);
    }
}
