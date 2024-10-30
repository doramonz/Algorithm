package BOJ;

import java.io.*;
import java.util.*;

public class BOJ11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        int[] result = new int[n + m];
        int i = 0;
        int j = 0;
        int k = 0;
        st = new StringTokenizer(br.readLine());
        for (int in = 0; in < arr1.length; in++)
            arr1[in] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int in = 0; in < arr2.length; in++)
            arr2[in] = Integer.parseInt(st.nextToken());
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] >= arr2[j]) {
                result[k++] = arr2[j++];
            } else {
                result[k++] = arr1[i++];
            }
        }
        while (i < arr1.length) {
            result[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }
        StringBuilder sb = new StringBuilder();
        for (int in = 0; in < result.length; in++)
            sb.append(result[in] + " ");
        System.out.println(sb.toString());
    }
}
