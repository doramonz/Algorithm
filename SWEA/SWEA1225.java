package SWEA;

import java.io.*;
import java.util.*;

public class SWEA1225 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int m = 1;
            int n = Integer.parseInt(br.readLine());
            sb.append("#" + n + " ");
            Queue<Integer> queue = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 8; j++) {
                queue.add(Integer.parseInt(st.nextToken()));
            }
            while (true) {
                if (queue.peek() - m < 0) {
                    queue.poll();
                    queue.add(0);
                    break;
                }
                queue.add(queue.poll() - m++);
                if (m > 5)
                    m = 1;
            }
            for (int j = 0; j < 8; j++) {
                sb.append(queue.poll() + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
