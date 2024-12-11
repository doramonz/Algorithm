package Programmers;

import java.util.Arrays;

public class Programmers42747 {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for (int i = 0; i <= citations.length; i++) {
            int left = 0;
            int right = citations.length - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (citations[mid] >= i) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if (citations.length - left >= i && left - i <= i)
                answer = i;
        }

        return answer;
    }
}
