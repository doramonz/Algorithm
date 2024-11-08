package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2568 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (x, y) -> {
            return x[0] - y[0];
        });
        int[] size = new int[n];
        int index = 0;
        int[] size2 = new int[n];
        for (int i = 0; i < n; i++) {
            if (arr[i][1] > size[index]) {
                index++;
                size[index] = arr[i][1];
                size2[i] = index;
            } else {
                int a = 0;
                int b = index;
                int mid;
                while (a < b) {
                    mid = (a + b) / 2;
                    if (size[mid] > arr[i][1]) {
                        b = mid;
                    } else {
                        a = mid + 1;
                    }
                }
                size[b] = arr[i][1];
                size2[i] = b;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(n - index).append("\n");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            if (size2[i] == index) {
                index--;
            } else {
                list.add(arr[i][0]);
            }
        }
        Collections.sort(list);
        for (int i : list) {
            sb.append(i).append("\n");
        }
        System.out.println(sb.toString());
    }
}
