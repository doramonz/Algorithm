package BOJ;

import java.io.*;
import java.util.*;

public class BOJ11723 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        boolean[] set = new boolean[21];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "add":
                    set[Integer.parseInt(st.nextToken())] = true;
                    break;
                case "remove":
                    set[Integer.parseInt(st.nextToken())] = false;
                    break;
                case "check":
                    sb.append(set[Integer.parseInt(st.nextToken())] ? 1 : 0).append("\n");
                    break;
                case "toggle":
                    int idx = Integer.parseInt(st.nextToken());
                    if (set[idx]) {
                        set[idx] = false;
                    } else {
                        set[idx] = true;
                    }
                    break;
                case "all":
                    for (int j = 1; j <= 20; j++)
                        set[j] = true;
                    break;
                case "empty":
                    for (int j = 1; j <= 20; j++)
                        set[j] = false;
                    break;
            }
        }
        System.out.println(sb.toString());

    }
}
