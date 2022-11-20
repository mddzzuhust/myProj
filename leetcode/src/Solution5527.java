package leetcode;

public class Solution5527 {
    int mod = 1000000007;

    public int numberOfSets(int n, int k) {
        int[][] dpT = new int[n + 1][k + 1];
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 2; i < n + 1; i++) {
            dp[i][1] = i * (i - 1) / 2;
            dpT[i][1] = i - 1;
        }

        for (int j = 2; j <= k; j++) {
            dpT[j + 1][j] = 1;
            dp[j + 1][j] = 1;
            for (int i = j + 2; i <= n; i++) {
                dpT[i][j] = dpT[i - 1][j] + dp[i - 1][j - 1];
                dpT[i][j] %= mod;
                dp[i][j] = dp[i - 1][j] + dpT[i][j];
                dp[i][j] %= mod;
            }
        }
        return dp[n][k];
    }

    public static void main(String[] args) {
        Solution5527 s = new Solution5527();
        System.out.println(s.numberOfSets(5, 3));
    }
}
