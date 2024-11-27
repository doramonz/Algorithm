package BOJ;

import java.io.*;
import java.util.*;

public class BOJ5430 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t_case = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t_case; i++) {
            String command = br.readLine();
            int k = Integer.parseInt(br.readLine());
            Deque<Integer> deque = new ArrayDeque<>();

            String temp = br.readLine().substring(1);
            if (k > 0) {
                String[] split = temp.substring(0, temp.length() - 1).split(",");
                for (int j = 0; j < k; j++) {
                    deque.add(Integer.parseInt(split[j]));
                }
            }
            boolean flag = true;
            boolean bf = false;
            for (char c : command.toCharArray()) {
                if (c == 'R') {
                    flag = !flag;
                } else {
                    if (deque.size() == 0) {
                        sb.append("error\n");
                        bf = true;
                        break;
                    }
                    if (flag) {
                        deque.removeFirst();
                    } else {
                        deque.removeLast();
                    }
                }
            }
            if (bf)
                continue;
            sb.append("[");
            while (!deque.isEmpty()) {
                if (flag) {
                    sb.append(deque.removeFirst());
                } else {
                    sb.append(deque.removeLast());
                }
                if (!deque.isEmpty())
                    sb.append(",");
            }
            sb.append("]\n");
        }
        System.out.println(sb.toString());
    }
}
