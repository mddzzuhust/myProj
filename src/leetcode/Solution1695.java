package leetcode;

import greedy.Solution;

import java.util.HashSet;
import java.util.Set;

public class Solution1695 {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0, sum = 0, start = 0;
        for (int i = 0; i < nums.length; i++) {
            if(!set.contains(nums[i])){
                set.add(nums[i]);
                sum += nums[i];
                max = Math.max(sum,max);
            }else {
                while (nums[i]!=nums[start]){
                    sum -= nums[start];
                    set.remove(nums[start]);
                    start++;
                }
                start++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution1695 s = new Solution1695();
        int[] nums = new int[]{5,2,1,2,5,2,1,2,5};
        System.out.println(s.maximumUniqueSubarray(nums));
    }
}
