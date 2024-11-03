package Programmers;

import java.util.*;

public class Programmers250136 {
    public int solution(int[][] land) {
        int answer = 0;

        int[] oilCount = new int[land.length * land[0].length / 2 + 10];
        int oilIndex = 2;

        int[] dx = new int[] { 0, 1, 0, -1 };
        int[] dy = new int[] { 1, 0, -1, 0 };

        for (int i = 0; i < land[0].length; i++) {
            for (int j = 0; j < land.length; j++) {
                int oil = 0;
                if (land[j][i] != 1)
                    continue;
                int[] point = new int[] { i, j };
                Queue<int[]> queue = new ArrayDeque<>();
                queue.add(point);
                land[j][i] = oilIndex;
                oil++;
                while (!queue.isEmpty()) {
                    int[] v = queue.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = v[0] + dx[k];
                        int ny = v[1] + dy[k];
                        if (nx < 0 || ny < 0 || nx >= land[0].length || ny >= land.length)
                            continue;
                        if (land[ny][nx] != 1)
                            continue;
                        land[ny][nx] = oilIndex;
                        oil++;
                        queue.add(new int[] { nx, ny });
                    }
                }
                oilCount[oilIndex++] = oil;
            }
        }
        for (int i = 0; i < land[0].length; i++) {
            TreeSet<Integer> treeSet = new TreeSet<>();
            int oil = 0;
            for (int j = 0; j < land.length; j++) {
                if (land[j][i] == 0)
                    continue;
                if (treeSet.contains(land[j][i]))
                    continue;
                oil += oilCount[land[j][i]];
                treeSet.add(land[j][i]);
            }
            answer = Math.max(answer, oil);
        }
        return answer;
    }

    public static void main(String[] args) {
        Programmers250136 programmers = new Programmers250136();
        int[][] arr1 = new int[][] { { 0, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 1, 1, 0, 0 }, { 1, 1, 0, 0, 0, 1, 1, 0 },
                { 1, 1, 1, 0, 0, 0, 0, 0 }, { 1, 1, 1, 0, 0, 0, 1, 1 } };
        int[][] arr2 = new int[][] { { 1, 0, 1, 0, 1, 1 }, { 1, 0, 1, 0, 0, 0 }, { 1, 0, 1, 0, 0, 1 },
                { 1, 0, 0, 1, 0, 0 }, { 1, 0, 0, 1, 0, 1 }, { 1, 0, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1, 1 } };

        System.out.println(programmers.solution(arr1) == 9);
        System.out.println(programmers.solution(arr2) == 16);

    }
}
