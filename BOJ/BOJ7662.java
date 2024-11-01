package BOJ;

import java.io.*;
import java.util.*;

public class BOJ7662 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            int m = Integer.parseInt(br.readLine());
            for (int j = 0; j < m; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int value = Integer.parseInt(st.nextToken());
                if ("I".equals(command)) {
                    treeMap.put(value, treeMap.getOrDefault(value, 0) + 1);
                } else if (!treeMap.isEmpty()) {
                    if (value == 1) {
                        int key = treeMap.lastKey();
                        if (treeMap.get(key) == 1) {
                            treeMap.remove(key);
                        } else {
                            treeMap.put(key, treeMap.get(key) - 1);
                        }
                    } else {
                        int key = treeMap.firstKey();
                        if (treeMap.get(key) == 1) {
                            treeMap.remove(key);
                        } else {
                            treeMap.put(key, treeMap.get(key) - 1);
                        }
                    }
                }
            }
            if (treeMap.isEmpty()) {
                sb.append("EMPTY" + "\n");
            } else {
                sb.append(treeMap.lastEntry().getKey() + " " + treeMap.firstEntry().getKey() + "\n");
            }
        }
        System.out.println(sb.toString());
    }
}
