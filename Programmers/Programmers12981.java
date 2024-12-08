package Programmers;

import java.util.*;

public class Programmers12981 {
    static public int[] solution(int n, String[] words) {
        int index = 0;
        int round = 0;
        Set<String> set = new HashSet<>();
        set.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (set.contains(words[i]) || words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) {
                index = i % n + 1;
                round = i / n + 1;
                break;
            }
            set.add(words[i]);
        }
        System.out.println(index + " " + round);
        return new int[] { index, round };
    }

    public static void main(String[] args) {
        int[] result1 = solution(3,
                new String[] { "tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank" });
        System.out.println(result1[0] == 3 && result1[1] == 3);
        int[] result2 = solution(5, new String[] { "hello", "observe", "effect", "take", "either", "recognize",
                "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive" });
        System.out.println(result2[0] == 0 && result2[1] == 0);
        int[] result3 = solution(2, new String[] { "hello", "one", "even", "never", "now", "world", "draw" });
        System.out.println(result3[0] == 1 && result3[1] == 3);
    }
}
