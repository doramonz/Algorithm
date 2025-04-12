package BOJ;

import java.util.*;
import java.io.*;

public class BOJ1822 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<Integer> set = new TreeSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            set.add(Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++)
            set.remove(Integer.parseInt(st.nextToken()));
        StringBuilder sb = new StringBuilder();
        sb.append(set.size()).append("\n");
        for (int v : set)
            sb.append(v).append(" ");
        System.out.println(sb);
    }
}
