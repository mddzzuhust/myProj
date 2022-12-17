public class Solution486 {
    public boolean PredictTheWinner(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            dp[i] = nums[i];
        }
        for (int i = length-2; i >= 0; i--) {
            for (int j = i+1; j < length; j++) {
                dp[j] = Math.max(nums[i]-dp[j], nums[j]-dp[j-1]);
            }
        }
        return dp[length-1] >= 0;
    }
}
