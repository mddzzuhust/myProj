package leetcode;

import java.util.Arrays;

public class Solution324 {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length, i = 0;
        int[] smaller = new int[len % 2 == 0 ? len / 2 : (len / 2 + 1)];
        int[] bigger = new int[len / 2];

        System.arraycopy(nums, 0, smaller, 0, smaller.length);
        System.arraycopy(nums, smaller.length, bigger, 0, len / 2);

        for (; i < len / 2; i++) {
            nums[2 * i] = smaller[smaller.length - 1 - i];
            nums[2 * i + 1] = bigger[len / 2 - 1 - i];
        }

        if(len%2!=0)
            nums[2*i] = smaller[smaller.length-1-i];
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 1, 1, 6, 4};
        Solution324 solution324 = new Solution324();
        solution324.wiggleSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }
}
