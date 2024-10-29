package BOJ;

import java.io.*;
import java.util.*;

public class BOJ15686 {
    static int n;
    static int m;
    static int[][] map;
    static List<int[]> chicken = new ArrayList<>();
    static List<int[]> house = new ArrayList<>();

    static int min = Integer.MAX_VALUE;

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static boolean next_permutation(int[] arr) {
        int i = arr.length - 1;
        int j = arr.length - 1;
        while (i > 0 && arr[i - 1] >= arr[i])
            i--;
        if (i == 0)
            return false;
        while (j > 0 && arr[i - 1] >= arr[j])
            j--;
        swap(arr, i - 1, j);
        j = arr.length - 1;
        while (i < j)
            swap(arr, i++, j--);
        return true;
    }

    static void chicken(int index, List<int[]> visit) {
        if (visit.size() == m) {
            int sum = 0;
            for (int i = 0; i < house.size(); i++) {
                int distance = Integer.MAX_VALUE;
                for (int j = 0; j < visit.size(); j++) {
                    int temp = Math.abs(house.get(i)[0] - visit.get(j)[0])
                            + Math.abs(house.get(i)[1] - visit.get(j)[1]);
                    distance = Math.min(distance, temp);
                }
                sum += distance;
            }
            min = Math.min(min, sum);
            return;
        }
        if (index >= chicken.size())
            return;
        visit.add(chicken.get(index));
        chicken(index + 1, visit);
        visit.remove(visit.size() - 1);
        chicken(index + 1, visit);
    }

    static void chicken2(int m) {
        int[] arr2 = new int[chicken.size()];
        for (int i = chicken.size() - m; i < chicken.size(); i++)
            arr2[i] = 1;
        do {
            int sum = 0;
            for (int i = 0; i < house.size(); i++) {
                int distance = Integer.MAX_VALUE;
                for (int j = 0; j < arr2.length; j++) {
                    if (arr2[j] == 0)
                        continue;
                    int temp = Math.abs(house.get(i)[0] - chicken.get(j)[0])
                            + Math.abs(house.get(i)[1] - chicken.get(j)[1]);
                    distance = Math.min(distance, temp);
                }
                sum += distance;
            }
            min = Math.min(min, sum);
        } while (next_permutation(arr2));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1)
                    house.add(new int[] { i, j });
                if (map[i][j] == 2)
                    chicken.add(new int[] { i, j });
            }
        }
        // chicken(0, new ArrayList<>());
        chicken2(m);
        System.out.println(min);
    }
}
