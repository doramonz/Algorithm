package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1991 {
    static StringBuilder sb = new StringBuilder();
    static int[][] arr;

    static void prev(int index) {
        if (index < 0)
            return;
        sb.append((char) (index + 65));
        prev(arr[index][0]);
        prev(arr[index][1]);
    }

    static void mid(int index) {
        if (index < 0)
            return;
        mid(arr[index][0]);
        sb.append((char) (index + 65));
        mid(arr[index][1]);
    }

    static void next(int index) {
        if (index < 0)
            return;
        next(arr[index][0]);
        next(arr[index][1]);
        sb.append((char) (index + 65));
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[26][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = st.nextToken().charAt(0) - 65;
            int second = st.nextToken().charAt(0) - 65;
            int third = st.nextToken().charAt(0) - 65;
            arr[first][0] = second;
            arr[first][1] = third;
        }
        prev(0);
        sb.append("\n");
        mid(0);
        sb.append("\n");
        next(0);
        System.out.println(sb.toString());
    }
}
