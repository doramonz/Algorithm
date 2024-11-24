package BOJ;

import java.io.*;
import java.util.*;

public class BOJ14425 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // int size = 10000*500+5;
        // int[][] tri = new int[size][26];
        // boolean[] chk = new boolean[size];
        // for (int i = 0; i < size; i++)
        // for (int j = 0; j < 26; j++)
        // tri[i][j] = -1;
        // int cnt = 1;
        // for (int i = 0; i < n; i++) {
        // String temp = br.readLine();
        // int cur = 0;
        // for (char c : temp.toCharArray()) {
        // if (tri[cur][c - 'a'] == -1)
        // tri[cur][c - 'a'] = cnt++;
        // cur = tri[cur][c - 'a'];
        // }
        // chk[cur] = true;
        // }
        // for (int j = 0; j < m; j++) {
        // String temp = br.readLine();
        // int cur = 0;
        // boolean flag = true;
        // for (char c : temp.toCharArray()) {
        // if (tri[cur][c - 'a'] == -1) {
        // flag = false;
        // break;
        // }
        // cur = tri[cur][c - 'a'];
        // }
        // if (flag&&chk[cur])
        // result++;
        // }
        Set<String> set = new TreeSet<>();
        for (int i = 0; i < n; i++)
            set.add(br.readLine());
        for (int i = 0; i < m; i++)
            if (set.contains(br.readLine()))
                result++;
        System.out.println(result);
    }
}
