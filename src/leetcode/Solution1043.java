package leetcode;

public class Solution1043 {
    public int maxSumAfterPartitioning(int[] A, int K) {
        int n = A.length;
        int[] dp = new int[n+1];

        for (int i = 1; i <= n; i++) {
            int maxN = -1;
            for (int j = i-1; j >= Math.max(0,i-K); j--) {
                maxN = Math.max(maxN,A[j]);
                dp[i] = Math.max(dp[i],dp[j]+maxN*(i-j));
            }
        }
        return dp[n];
    }
}
