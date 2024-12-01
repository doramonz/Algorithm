package BOJ;

import java.io.*;
import java.util.*;

public class BOJ11053 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int index = 0;
        arr[index++] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < n; i++) {
            int v = Integer.parseInt(st.nextToken());
            if (v > arr[index - 1]) {
                arr[index++] = v;
            } else {
                int left = 0;
                int right = index - 1;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (arr[mid] < v) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                if (left < index) {
                    arr[left] = v;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++)
            if (arr[i] != 0)
                result = i+1;
            System.out.println(result);
    }
}
