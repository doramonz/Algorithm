package Programmers;

import java.util.*;

public class Programmers42586 {

    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int[] count = new int[progresses.length];
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < 100; j++) {
            for (int i = 0; i < progresses.length; i++) {
                if (progresses[i] < 100) {
                    progresses[i] += speeds[i];
                    count[i]++;
                }
            }
        }
        int index = 0;
        while (index < count.length) {
            int cum = 0;
            int value = count[index];
            while (index < count.length && count[index] <= value) {
                cum++;
                index++;
            }
            list.add(cum);
        }
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            answer[i] = list.get(i);
        return answer;
    }
}
