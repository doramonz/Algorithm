package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1368 {

    static int find(int[] arr, int i) {
        if (arr[i] == i)
            return i;
        arr[i] = find(arr, arr[i]);
        return arr[i];
    }

    static void union(int[] arr, int i, int j) {
        int a = find(arr, i);
        int b = find(arr, j);
        if (a < b) {
            arr[b] = a;
        } else {
            arr[a] = b;
        }
    }

    static long cal(int[][] waterWays, int[] wells) {
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i < waterWays.length; i++)
            for (int j = 1; j < waterWays.length; j++)
                if (waterWays[i][j] != 0) {
                    list.add(new int[] { i, j, waterWays[i][j] });
                }
        for (int i = 1; i < waterWays.length; i++) {
            list.add(new int[] { i, waterWays.length, wells[i] });
            list.add(new int[] { waterWays.length, i, wells[i] });
        }
        Collections.sort(list, new Comparator<>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[2] - b[2];
            }
        });
        int[] p = new int[waterWays.length+1];
        long value = 0;
        for (int i = 1; i < waterWays.length+1; i++) {
            p[i] = i;
        }
        for (int i = 0; i < list.size(); i++) {
            int[] get = list.get(i);
            if (find(p, get[0]) != find(p, get[1])) {
                union(p, get[0], get[1]);
                value += get[2];
            }
        }
        return value;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] wells = new int[n + 1];
        for (int i = 1; i < wells.length; i++)
            wells[i] = Integer.parseInt(br.readLine());
        int[][] waterWays = new int[n + 1][n + 1];
        for (int i = 1; i < waterWays.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < waterWays.length; j++)
                waterWays[i][j] = Integer.parseInt(st.nextToken());
        }
        System.out.println(cal(waterWays, wells));
    }
}
