package Programmers;

import java.util.*;

public class Programmers64065 {
    public int[] solution(String s) {
        Set<String> set = new LinkedHashSet<>();
        String[] split = s.replaceAll("\\{", " ").replaceAll("\\}", " ").trim().split(" ");
        Arrays.sort(split, (x, y) -> x.length() - y.length());
        Arrays.stream(split).forEach(x -> {
            Arrays.stream(x.split(",")).forEach(set::add);
        });
        return set.stream().mapToInt(Integer::parseInt).toArray();
    }
}
