package BOJ;

import java.io.*;
import java.util.LinkedList;

public class BOJ10974 {
    static boolean[] arr = new boolean[8];
    static StringBuilder sb = new StringBuilder();
    static LinkedList<Integer> list = new LinkedList<>();

    static void func(int n) {
        if (list.size() == n) {
            for (int i : list) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!arr[i]) {
                arr[i] = true;
                list.add(i + 1);
                func(n);
                list.removeLast();
                arr[i] = false;
            }
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        func(Integer.parseInt(br.readLine()));
        System.out.println(sb.toString());
    }
}
