package BOJ;

import java.util.*;
import java.io.*;

public class BOJ10815 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] cards = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            cards[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(cards);
        n = Integer.parseInt(br.readLine());
        int[] finds = new int[n];
        int[] results = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            finds[i] = Integer.parseInt(st.nextToken());
        for (int i = 0;i<finds.length;i++) {
            int left = 0;
            int right = cards.length-1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (cards[mid] == finds[i]) {
                    results[i] = 1;
                    break;
                } else if (cards[mid] < finds[i]) {
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<results.length;i++)
            sb.append(results[i]).append(" ");
        System.out.println(sb);
    }
}
