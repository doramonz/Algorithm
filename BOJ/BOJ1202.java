package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1202 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] jewel = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            jewel[i][0] = Integer.parseInt(st.nextToken());
            jewel[i][1] = Integer.parseInt(st.nextToken());
        }
        int[] bag = new int[k];
        for (int i = 0; i < k; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewel, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1])
                    if (o1[0] == o2[0])
                        return 0;
                    else
                        return o1[0] > o2[0] ? 1 : -1;
                return o1[1] > o2[1] ? -1 : 1;
            }

        });

        TreeMap<Integer, Integer> bagSet = new TreeMap<>();
        for (int i = 0; i < k; i++) {
            bagSet.put(bag[i], bagSet.getOrDefault(bag[i], 0) + 1);
        }

        long value = 0;
        for (int i = 0; i < jewel.length; i++) {
            Integer v = bagSet.ceilingKey(jewel[i][0]);
            if (v != null) {
                bagSet.put(v, bagSet.get(v) - 1);
                value += jewel[i][1];
                if (bagSet.get(v) == 0)
                    bagSet.remove(v);
            }
        }
        System.out.println(value);
    }
}
