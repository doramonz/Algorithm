package BOJ;

import java.io.*;
import java.util.*;

public class BOJ16953 {
    static long a;
    static long b;
    static long min = Integer.MAX_VALUE;

    static void recur(long v, long c){
        if(v==b){
            min = Math.min(c, min);
            return;
        }
        if(v>b)
        return;
        recur(v*2, c+1);
        recur(v*10+1, c+1);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        recur(a, 1);
        System.out.println(min==Integer.MAX_VALUE?-1:min);
    }
}
