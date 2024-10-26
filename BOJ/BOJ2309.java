package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2309 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        List<Integer> list = new ArrayList<>();
        boolean find = false;
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                int sum = 0;
                for (int k = 0; k < 9; k++) {
                    if (k != i && k != j)
                        sum += arr[k];
                }
                if (sum == 100) {
                    for (int k = 0; k < 9; k++) {
                        if (k != i && k != j)
                            list.add(arr[k]);
                    }
                    find = true;
                    break;
                }
            }
            if (find)
                break;
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (int i : list) {
            sb.append(i + "\n");
        }
        System.out.println(sb.toString());
    }
}
