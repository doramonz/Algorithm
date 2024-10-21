package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1920 {
    static int[] search(int[] arr, int[] find) {
        Arrays.sort(arr);
        int[] result = new int[find.length];
        for (int i = 0; i < find.length; i++) {
            int left = 0;
            int right = arr.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (find[i] == arr[mid]) {
                    result[i] = 1;
                    break;
                }
                if (arr[mid] < find[i]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        n = Integer.parseInt(br.readLine());
        s = br.readLine().split(" ");
        int[] find = new int[n];
        for (int i = 0; i < n; i++) {
            find[i] = Integer.parseInt(s[i]);
        }
        int[] result = search(arr, find);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i] + "\n");
        }
        System.out.println(sb.toString());
    }
}
