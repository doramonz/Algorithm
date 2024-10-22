package BOJ;

import java.io.*;
import java.util.*;

public class BOJ10816 {
    static int[] getCardCount(int[] cards, int[] find) {
        Arrays.sort(cards);
        int[] result = new int[find.length];
        for (int i = 0; i < find.length; i++) {
            int l = 0;
            int r = cards.length;
            int lv = 0;
            int rv = 0;
            int mid = 0;
            while (l < r) {
                mid = (r + l) / 2;
                if (cards[mid] >= find[i]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            lv = r;
            l = 0;
            r = cards.length;
            while (l < r) {
                mid = (r + l) / 2;
                if (cards[mid] > find[i]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            rv = r;
            result[i] = rv - lv;
        }
        return result;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] cards = new int[n];
        String[] temp = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(temp[i]);
        }
        n = Integer.parseInt(br.readLine());
        temp = br.readLine().split(" ");
        int[] find = new int[n];
        for (int i = 0; i < n; i++) {
            find[i] = Integer.parseInt(temp[i]);
        }
        int[] result = getCardCount(cards, find);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i] + " ");
        }
        System.out.println(sb.toString());
    }
}
