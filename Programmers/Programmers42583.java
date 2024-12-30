package Programmers;

import java.util.ArrayDeque;
import java.util.Deque;

public class Programmers42583 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int currentWeight = 0;
        Deque<int[]> deque = new ArrayDeque<>();
        int i = 0;
        while (true) {
            if (!deque.isEmpty() && time - deque.peek()[0] >= bridge_length) {
                currentWeight -= deque.poll()[1];
            }
            if (i < truck_weights.length && currentWeight + truck_weights[i] <= weight) {
                deque.add(new int[] { time, truck_weights[i] });
                currentWeight += truck_weights[i];
                i++;
            }
            time++;
            if (deque.isEmpty() && i == truck_weights.length)
                break;
        }
        return time;
    }
}
