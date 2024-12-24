package Programmers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Programmers49191 {
        public int solution(int n, int[][] results) {
        int answer = 0;
        List<Integer>[] up = new ArrayList[n+1];
        List<Integer>[] down = new ArrayList[n+1];
        for(int i = 0;i<n+1;i++){
            up[i] = new ArrayList<>();
            down[i] = new ArrayList<>();
        }
        for(int i = 0;i<results.length;i++){
            up[results[i][1]].add(results[i][0]);
            down[results[i][0]].add(results[i][1]);
        }
        for(int i = 1;i<=n;i++){
            boolean[] vis = new boolean[n+1];
            Queue<Integer> queue = new ArrayDeque<>();
            vis[i] = true;
            queue.add(i);
            while(!queue.isEmpty()){
                int v = queue.poll();
                for(int k : up[v]){
                    if(!vis[k]){
                        vis[k] = true;
                        queue.add(k);
                    }
                }
            }
            queue.add(i);
            while(!queue.isEmpty()){
                int v = queue.poll();
                for(int k : down[v]){
                    if(!vis[k]){
                        vis[k] = true;
                        queue.add(k);
                    }
                }
            }
            for(int j = 1;j<=n;j++){
                if(!vis[j])
                    break;
                if(j==n)
                    answer++;
            }
        }
        return answer;
    }
}
