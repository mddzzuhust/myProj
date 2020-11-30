package leetcode;

import java.util.Arrays;

public class Solution1671 {
    public int minimumMountainRemovals(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = 0;
        right[0] = 0;
        int[] dp = new int[len];
        int[] pd = new int[len];
        dp[0] = nums[0];
        pd[0] = nums[len - 1];
        int L = 1;
        int R = 1;
        for (int i = 1; i < len - 1; i++) {
            int l = Arrays.binarySearch(dp, 0, L, nums[i]);
            if (l < 0) {
                l = -(l + 1);
            }
            left[i] = l + 1;
            dp[l] = nums[i];
            if (l == L) {
                L++;
            }
            int r = Arrays.binarySearch(pd, 0, R, nums[len - 1 - i]);
            if (r < 0) {
                r = -(r + 1);
            }
            right[i] = r + 1;
            pd[r] = nums[len - 1 - i];
            if (r == R) {
                R++;
            }
        }
        int max = 0;
        for (int i = 1; i < len - 1; i++) {
            max = Math.max(left[i] + right[len - 1 - i] - 1, max);
        }
        if (max == 0)
            return -1;
        return len - max;
    }

    public static void main(String[] args) {
        Solution1671 s = new Solution1671();
        int[] nums = new int[]{1,3,1};
        System.out.println(s.minimumMountainRemovals(nums));
    }
}
