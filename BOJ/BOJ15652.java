package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ15652 {
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int k;
    static int[] arr;

    static void recur(int num, int count) {
        if (count == k) {
            for (int i = 0; i < k; i++)
                sb.append(arr[i]).append(" ");
            sb.append("\n");
            return;
        }
        for(int i = num;i<=n;i++){
            arr[count] = i;
            recur(i, count+1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[k];
        recur(1, 0);
        System.out.println(sb);
    }
}
