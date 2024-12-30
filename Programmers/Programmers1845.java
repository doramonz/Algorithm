package Programmers;

import java.util.HashSet;
import java.util.Set;

public class Programmers1845 {
        public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums)
            set.add(n);
        return set.size()>=nums.length/2?nums.length/2:set.size();
    }
}
