

import java.util.Arrays;

public class Solution1639 {
    int MOD = (int)1e9+7;
    int n,m,t;
    public int numWays(String[] words, String target) {
        n = words[0].length();
        m = words.length;
        t = target.length();
        int[][] f = new int[n][26];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int k = words[i].charAt(j)-'a';
                f[j][k]++;
            }
        }

        int[][] dp = new int[n+1][n+1];
        Arrays.fill(dp[0],1);
        for (int i = 1; i <= t; i++) {
            int k = target.charAt(i-1)-'a';
            for (int j = i; j <= n; j++) {
                if(f[j-1][k]>0){
                    dp[i][j] = (int)(((long)dp[i-1][j-1]*f[j-1][k]+dp[i][j-1])%MOD);
                }else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[t][n];
    }
}
