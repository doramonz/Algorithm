package Programmers;

import java.util.PriorityQueue;

public class Programmers42626 {
        public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(long i : scoville)
            pq.add(i);
        while(pq.size()>1&&pq.peek()<K){
            pq.add(pq.poll()+pq.poll()*2);
            answer++;
        }
        return pq.peek()<K?-1:answer;
    }
}
