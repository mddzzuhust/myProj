package leetcode;

import java.util.Arrays;

public class Solution1658 {
    public int minOperations(int[] nums, int x) {
        int maxPart = -1;
        int sum = Arrays.stream(nums).sum();
        int currentSum = 0;
        int left = 0;
        int right = 0;
        while (left < nums.length) {
            if (right < nums.length) {
                currentSum += nums[right];
            }
            while (currentSum > sum - x && left < nums.length) {
                currentSum -= nums[left++];
            }
            if (currentSum == sum - x){
                maxPart = Math.max(maxPart,right-left);
            }
            if(right == nums.length){
                left++;
            }
        }
        return maxPart==-1?-1:nums.length-maxPart;
    }
}
