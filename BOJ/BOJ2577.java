package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2577 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int mul = Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine());
        int[] arr = new int[10];
        while (mul > 0) {
            arr[mul % 10]++;
            mul /= 10;
        }
        for(int i  =0;i<10;i++)
        System.out.println(arr[i]);
    }
}
