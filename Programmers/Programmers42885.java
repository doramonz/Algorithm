package Programmers;

import java.util.Arrays;
import java.util.Collections;

public class Programmers42885 {
        public int solution(int[] people, int limit) {
        int answer = 0;
        Integer[] sorted = new Integer[people.length];
        for(int i = 0;i<people.length;i++)
            sorted[i] = people[i];
        Arrays.sort(sorted,Collections.reverseOrder());
        int j = people.length-1;
        int i = 0;
        while(i<=j){
            if(i!=j&&sorted[i]+sorted[j]<=limit)
                j--;
            answer++;
            i++;
        }
        return answer;
    }
}
