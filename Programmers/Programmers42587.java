package Programmers;

import java.util.*;

class Programmers42587 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
            queue.add(new int[] { i, priorities[i] });
        }
        while (!queue.isEmpty()) {
            int[] v = queue.poll();
            if (pq.peek() != v[1]) {
                queue.add(v);
                continue;
            }
            answer++;
            pq.poll();
            if (v[0] == location)
                break;
        }

        return answer;
    }
}