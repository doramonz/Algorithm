package BOJ;

import java.io.*;
import java.util.*;

public class BOJ12865 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int kg = Integer.parseInt(temp[1]);
        int[][] arr = new int[n+1][kg+1];
        for (int i = 1; i <= n; i++) {
            temp = br.readLine().split(" ");
            for (int j = 1; j <= kg; j++) {
                arr[i][j] = arr[i - 1][j];
                if (j >= Integer.parseInt(temp[0])) {
                    arr[i][j] = Math.max(arr[i - 1][j],
                            Integer.parseInt(temp[1]) + arr[i - 1][j - Integer.parseInt(temp[0])]);
                }
            }
        }
        System.out.println(arr[n][kg]);
    }
}
