package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1197 {
    static int[] rank;

    static int find(int[] p, int a) {
        if (p[a] == a)
            return a;
        p[a] = find(p, p[a]);
        return p[a];
    }

    static void union(int[] p, int a, int b) {
        int av = find(p, a);
        int bv = find(p, b);
        if (av == bv)
            return;
        if (rank[av] > rank[bv]) {
            p[bv] = av;
        } else if (rank[bv] > rank[av]) {
            p[av] = bv;
        } else {
            p[bv] = av;
            rank[av]++;
        }
        // if (av < bv)
        //     p[bv] = av;
        // else
        //     p[av] = bv;
    }

    static long kruscal(List<int[]> arr, int v) {
        Collections.sort(arr, new Comparator<>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[2] - b[2];
            }
        });
        rank = new int[v+1];
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
        return value;
    }

    static long prim(List<int[]>[] arr, int v) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        boolean[] visit = new boolean[v + 1];
        int count = 0;
        long value = 0;
        for (int i = 0; i < arr[1].size(); i++)
            queue.add(arr[1].get(i));
        visit[1] = true;
        while (count < v - 1) {
            int[] poll = queue.poll();
            if (visit[poll[1]])
                continue;
            value += poll[2];
            count++;
            visit[poll[1]] = true;
            for (int[] e : arr[poll[1]]) {
                if (!visit[e[1]]) {
                    queue.add(e);
                }
            }
        }
        return value;
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
        List<int[]>[] arr2 = new List[v + 1];
        for (int i = 0; i < arr2.length; i++)
            arr2[i] = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            int a = arr.get(i)[0];
            int b = arr.get(i)[1];
            int c = arr.get(i)[2];
            arr2[a].add(new int[] { a, b, c });
            arr2[b].add(new int[] { b, a, c });
        }

        // kruscal's version
        System.out.println(kruscal(arr, v));

        // prim's version
        // System.out.println(prim(arr2, v));
    }
}
