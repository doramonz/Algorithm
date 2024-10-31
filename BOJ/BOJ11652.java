package BOJ;

import java.io.*;
import java.util.*;

public class BOJ11652 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr);

        int currentCount = 1;
        int maxCount = 0;
        long maxNumber = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i - 1] != arr[i]) {
                if (currentCount > maxCount) {
                    maxNumber = arr[i - 1];
                    maxCount = currentCount;
                }
                currentCount = 0;
            }
            currentCount++;
        }
        if (currentCount > maxCount) {
            maxNumber = arr[arr.length - 1];
        }
        System.out.println(maxNumber);
    }
}
