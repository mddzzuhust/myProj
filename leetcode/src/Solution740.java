package leetcode;

public class Solution740 {
    public int deleteAndEarn(int[] nums) {
        int[] count = new int[10001];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        int[] dp = new int[10001];
        if(count[1]!=0){
            dp[1]=count[1];
        }
        for (int i = 2; i <= 10000; i++) {
            dp[i] = Math.max(i*count[i]+dp[i-2],dp[i-1]);
        }
        return dp[10000];
    }

    public static void main(String[] args) {
        Solution740 s = new Solution740();
        int[] nums = new int[]{2, 2, 3, 3, 3, 4};
        System.out.println(s.deleteAndEarn(nums));
    }
}
