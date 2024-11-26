package BOJ;

import java.io.*;
import java.util.*;

public class BOJ13300 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[][] arr = new int[7][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[b][a]++;
        }
        int result = 0;
        for (int i = 1; i <= 6; i++) {
            result += (arr[i][0]) / r + (arr[i][1]) / r;
            if(arr[i][0]%r!=0)
            result++;
            if(arr[i][1]%r!=0)
            result++;
        }
        System.out.println(result);
    }
}
