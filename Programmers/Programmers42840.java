package Programmers;

import java.util.ArrayList;
import java.util.List;

public class Programmers42840 {
    static int[] one = new int[] { 1, 2, 3, 4, 5 };
    static int[] two = new int[] { 2, 1, 2, 3, 2, 4, 2, 5 };
    static int[] thr = new int[] { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int[] count = new int[3];
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == one[i % one.length])
                count[0]++;
            if (answers[i] == two[i % two.length])
                count[1]++;
            if (answers[i] == thr[i % thr.length])
                count[2]++;
        }
        int max = 0;
        for (int i = 0; i < 3; i++)
            max = Math.max(max, count[i]);
        for (int i = 0; i < 3; i++)
            if (count[i] == max)
                answer.add(i + 1);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
