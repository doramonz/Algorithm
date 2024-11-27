package BOJ;

import java.io.*;
import java.util.*;

public class BOJ18185 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long result = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i + 1] > arr[i + 2]) {
                int min = Math.min(arr[i], arr[i + 1] - arr[i + 2]);
                arr[i] -= min;
                arr[i + 1] -= min;
                result += min * 5;
                min = Math.min(arr[i], Math.min(arr[i + 1], arr[i + 2]));
                arr[i] -= min;
                arr[i + 1] -= min;
                arr[i + 2] -= min;
                result += min * 7;
            } else {
                int min = Math.min(arr[i], Math.min(arr[i + 1], arr[i + 2]));
                arr[i] -= min;
                arr[i + 1] -= min;
                arr[i + 2] -= min;
                result += min * 7;
                min = Math.min(arr[i], arr[i + 1]);
                arr[i] -= min;
                arr[i + 1] -= min;
                result += min * 5;
            }
            result += arr[i] * 3;
        }

        System.out.println(result);
    }
}
