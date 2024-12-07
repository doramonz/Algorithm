package BOJ;

import java.io.*;
import java.util.*;

public class BOJ11662 {
    static double getDist(double ax, double ay, double bx, double by) {
        return Math.sqrt(Math.pow(bx - ax, 2) + Math.pow(by - ay, 2));
    }

    static double minimumDist(int ax, int ay, int bx, int by, int cx, int cy, int dx, int dy) {
        double left = 0;
        double right = 1;
        while (left + 0.00000001 < right) {
            double mid1 = left + (right - left) / 3;
            double mid2 = left + (right - left) / 3 * 2;
            if (getDist(ax + (bx - ax) * mid1, ay + (by - ay) * mid1, cx + (dx - cx) * mid1,
                    cy + (dy - cy) * mid1) < getDist(ax + (bx - ax) * mid2, ay + (by - ay) * mid2,
                            cx + (dx - cx) * mid2,
                            cy + (dy - cy) * mid2)) {
                right = mid2;
            } else {
                left = mid1;
            }
        }
        return getDist(ax + (bx - ax) * left, ay + (by - ay) * left, cx + (dx - cx) * left,
                cy + (dy - cy) * left);
    }

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int ax = Integer.parseInt(st.nextToken());
        int ay = Integer.parseInt(st.nextToken());
        int bx = Integer.parseInt(st.nextToken());
        int by = Integer.parseInt(st.nextToken());
        int cx = Integer.parseInt(st.nextToken());
        int cy = Integer.parseInt(st.nextToken());
        int dx = Integer.parseInt(st.nextToken());
        int dy = Integer.parseInt(st.nextToken());

        System.out.printf("%.10f", minimumDist(ax, ay, bx, by, cx, cy, dx, dy));
    }
}
