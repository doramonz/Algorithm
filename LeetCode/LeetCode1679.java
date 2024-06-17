package LeetCode;

import java.util.Arrays;

public class LeetCode1679 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maxOperations(new int[]{3,1,3,4,3}, 6);
    }
}

class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int output = 0;
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            if(nums[left]+nums[right]==k){
                output++;
                left++;
                right--;
            }else if(nums[left]+nums[right]<k){
                left++;
            }else{
                right--;
            }
        }
        return output;
    }
}