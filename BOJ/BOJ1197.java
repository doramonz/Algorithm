package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1197 {
    static int find(int[] p, int a) {
        if (p[a] == a)
            return a;
        p[a] = find(p, p[a]);
        return p[a];
    }

    static void union(int[] p, int a, int b) {
        int av = find(p, a);
        int bv = find(p, b);
        if (av < bv)
            p[bv] = av;
        else
            p[av] = bv;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        List<int[]> arr = new ArrayList<>(100000);
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            arr.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()) });
        }
        Collections.sort(arr, new Comparator<>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[2] - b[2];
            }
        });
        int[] p = new int[v + 1];
        long value = 0;
        for (int i = 1; i < p.length; i++)
            p[i] = i;
        for (int i = 0; i < arr.size(); i++) {
            int[] node = arr.get(i);
            if (find(p, node[0]) != find(p, node[1])) {
                union(p, node[0], node[1]);
                value += node[2];
            }
        }
        System.out.println(value);
    }
}
