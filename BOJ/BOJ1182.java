package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1182 {
    static int n;
    static int target;
    static int count = 0;
    static int[] arr;

    static void func(int current, int sum) {
        if (current == n) {
            if (sum == target)
                count++;
            return;
        }
        func(current + 1, sum + arr[current]);
        func(current + 1, sum);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        target = Integer.parseInt(temp[1]);
        temp = br.readLine().split(" ");
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(temp[i]);
        }
        func(0, 0);
        if (target == 0) {
            count--;
        }
        System.out.println(count);
    }
}
