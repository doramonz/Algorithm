package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1158 {
    static class CList {
        CList next;
        int value;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        CList start = new CList();
        CList temp = new CList();
        start.next = temp;
        temp.value = 1;
        for (int i = 2; i <= n; i++) {
            CList cList = new CList();
            temp.next = cList;
            temp = cList;
            cList.value = i;
        }
        temp.next = start.next;
        temp = start;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k - 1; j++)
                temp = temp.next;
            sb.append(temp.next.value).append(", ");
            temp.next = temp.next.next;
        }
        String result = sb.substring(0,sb.length()-2);
        System.out.println(result+">");
    }
}
