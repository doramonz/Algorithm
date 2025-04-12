package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14956 {
    static int target;
    static int count;
    static int[] point = new int[2];
    static int x = 0;
    static int y = 0;

    static boolean check() {
        if (++count == target) {
            point[0] = y;
            point[1] = x;
            return true;
        }
        return false;
    }

    static void recur(int n, boolean rotate, int flap) {
        if (n == 2) {
            if (rotate) {
                x += flap;
                if (check())
                    return;
                y += 1;
                if (check())
                    return;
                x -= flap;
                if (check())
                    return;
                y += 1;
                if (check())
                    return;
            } else {
                y += 1;
                if (check())
                    return;
                x += flap;
                if (check())
                    return;
                y -= 1;
                if (check())
                    return;
                x += flap;
                if (check())
                    return;
            }
            return;
        }
        recur(n / 2, !rotate, flap);
        recur(n / 2, rotate, flap);
        recur(n / 2, rotate, flap);
        recur(n / 2, !rotate, flap * -1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        recur(n, false, 1);
        System.out.println(x+" "+y);
    }
}
