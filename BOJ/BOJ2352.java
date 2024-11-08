package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2352 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int[] cal = new int[n];
        int inx = 0;
        cal[0] = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] >cal[inx]) {
                inx++;
                cal[inx] = arr[i];
            } else {
                int pos = Arrays.binarySearch(cal, 0, inx, arr[i]);
                if (pos < 0)
                    pos = -(pos + 1);
                cal[pos] = arr[i];
            }
        }
        System.out.println(inx+1);
    }
}
