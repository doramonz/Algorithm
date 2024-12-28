package Programmers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Programmers86971 {
        static int bfs(List<Integer>[] wire, int w){
        boolean[] vis = new boolean[wire.length];
        int count = 1;
        Deque<Integer> deque = new ArrayDeque<>();
        vis[w] = true;
        deque.add(w);
        while(!deque.isEmpty()){
            int v = deque.poll();
            for(int i : wire[v]){
                if(!vis[i]){
                    vis[i] = true;
                    deque.add(i);
                    count++;
                }
            }
        }
        return count;
    }
    public int solution(int n, int[][] wires) {
        List<Integer>[] wire = new ArrayList[n+1];
        for(int i = 0;i<=n;i++)
            wire[i] = new ArrayList<>();
        for(int[] w : wires){
            wire[w[0]].add(w[1]);
            wire[w[1]].add(w[0]);
        }
        int min = 9999999;
        for(int[] w : wires){
            wire[w[0]].remove(new Integer(w[1]));
            wire[w[1]].remove(new Integer(w[0]));
            int l = bfs(wire, w[0]);
            int r = bfs(wire, w[1]);
            min = Math.min(min,Math.abs(l-r));
            wire[w[0]].add(w[1]);
            wire[w[1]].add(w[0]);
        }
        return min;
    }
}
