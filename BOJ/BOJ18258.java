package BOJ;

import java.io.*;
import java.util.*;

public class BOJ18258 {

    public static void main(String[] args) throws Exception {
        int[] arr = new int[2000000];
        int h = 0;
        int r = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":
                    arr[r++] = Integer.parseInt(st.nextToken());
                    break;
                case "pop":
                    if (h == r) {
                        sb.append(-1 + "\n");
                    } else {
                        sb.append(arr[h++] + "\n");
                    }
                    break;
                case "size":
                    sb.append(r - h + "\n");
                    break;
                case "empty":
                    sb.append((r == h ? 1 : 0) + "\n");
                    break;
                case "front":
                    if (h == r) {
                        sb.append(-1 + "\n");
                    } else {
                        sb.append(arr[h] + "\n");
                    }
                    break;
                case "back":
                    if (h == r) {
                        sb.append("-1" + "\n");
                    } else {
                        sb.append(arr[r - 1] + "\n");
                    }
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
