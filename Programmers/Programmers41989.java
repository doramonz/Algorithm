package Programmers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Programmers41989 {
        public int solution(int n, int[][] edge) {
        int answer = 0;
        List<Integer>[] graph = new ArrayList[n+1];
        for(int i = 0;i<n+1;i++)
            graph[i] = new ArrayList<>();
        for(int i = 0;i<edge.length;i++){
            graph[edge[i][0]].add(edge[i][1]);
            graph[edge[i][1]].add(edge[i][0]);
        }
        int[] vis = new int[n+1];
        for(int i = 0;i<n+1;i++)
            vis[i] = -1;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{1,0});
        vis[1] = 0;
        while(!queue.isEmpty()){
            int[] v = queue.poll();
            for(int i : graph[v[0]]){
                if(vis[i]==-1){
                    vis[i] = v[1]+1;
                    queue.add(new int[]{i,v[1]+1});
                }
            }
        }
        int max = 0;
        for(int i = 0;i<n+1;i++)
            max = Math.max(vis[i],max);
        for(int i = 0;i<n+1;i++)
            if(vis[i]==max)
                answer++;
        return answer;
    }
}
