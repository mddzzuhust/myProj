

public class Solution1696 {
    public int maxResult(int[] nums, int k) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            int max = Integer.MIN_VALUE;
            if (maxIndex >= i - k) {
                max = dp[maxIndex];
            } else {
                for (int j = i - 1; j >= 0 && j >= i - k; j--) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + nums[i];
            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        Solution1696 s = new Solution1696();
        int[] nums = new int[]{1,-5,-20,4,-1,3,-6,-3};
        System.out.println(s.maxResult(nums,2));
    }
}
