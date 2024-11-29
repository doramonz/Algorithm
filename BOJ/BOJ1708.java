package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1708 {
    static int[] result = new int[3];

    static void recur(int[][] arr) {
        int num = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] != num) {
                    for (int n = 0; n < 3; n++) {
                        for (int m = 0; m < 3; m++) {
                            int[][] newArr = new int[arr.length / 3][arr.length / 3];
                            for (int p = 0; p < newArr.length; p++) {
                                for (int q = 0; q < newArr.length; q++) {
                                    newArr[p][q] = arr[n * arr.length / 3 + p][m * arr.length / 3 + q];
                                }
                            }
                            recur(newArr);
                        }
                    }
                    return;
                }
            }
        }
        result[num + 1]++;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recur(arr);
        for(int i = 0;i<3;i++)
            System.out.println(result[i]);
    }
}
