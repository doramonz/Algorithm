package BOJ;

import java.io.*;
import java.util.*;

public class BOJ6603 {
    static int size;
    static List<Integer> list;
    static boolean[] flag;
    static StringBuilder sb = new StringBuilder();

    static void recur(int count, int index) {
        if (count == 6) {
            for (int i = 0; i < list.size(); i++)
                if (flag[i])
                    sb.append(list.get(i)).append(" ");
            sb.append("\n");
            return;
        }
        for (int i = index; i < list.size(); i++) {
            flag[i] = true;
            recur(count + 1, i + 1);
            flag[i] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (!(s = br.readLine()).equals("0")) {
            StringTokenizer st = new StringTokenizer(s);
            list = new ArrayList<>();
            size = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            flag = new boolean[list.size()];
            Collections.sort(list);
            recur(0, 0);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
