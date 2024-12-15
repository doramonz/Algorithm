package Programmers;

public class Programmers87946 {
    static int[][] s_dungeons;
    static boolean[] visited;
    static int max = 0;

    static void recur(int t, int count) {
        max = Math.max(max, count);
        for (int i = 0; i < s_dungeons.length; i++) {
            if (visited[i])
                continue;
            if (t < s_dungeons[i][0])
                continue;
            visited[i] = true;
            recur(t - s_dungeons[i][1], count + 1);
            visited[i] = false;
        }
    }

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        s_dungeons = dungeons;
        recur(k, 0);
        return max;
    }
}
