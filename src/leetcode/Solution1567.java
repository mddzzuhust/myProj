package leetcode;

public class Solution1567 {
    public int getMaxLen(int[] nums) {
        int[][] dp = new int[10000][2];
        dp[0][0] = dp[0][1] = 0;
        int ans = 0;
        for (int i = 1; i <= nums.length; i++) {
            if(nums[i-1] == 0) {
                dp[i][0] = 0;
                dp[i][1] = 0;
            } else if(nums[i-1] > 0) {
                dp[i][0] = dp[i-1][0] + 1;
                dp[i][1] = (dp[i-1][1]>0) ? (dp[i-1][1] + 1) : 0;
            } else {
                dp[i][0] = (dp[i-1][1]>0) ? (dp[i-1][1] + 1) : 0;
                dp[i][1] = dp[i-1][0] + 1;
            }
            ans = Math.max(ans,dp[i][0]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution1567 s = new Solution1567();
        int[] nums = new int[]{1,2,3,5,-6,4,0,10};
        System.out.println(s.getMaxLen(nums));
        System.out.println();
    }
}
