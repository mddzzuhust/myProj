

public class Solution1594 {
    public int maxProductPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        long mod = (long)(1e9+7);
        long[][][] dp = new long[n][m][2];
        dp[n-1][m-1][0] = grid[n-1][m-1];
        dp[n-1][m-1][1] = grid[n-1][m-1];

        for (int i = m-2; i >=0 ; i--) {
            dp[n-1][i][0] = dp[n-1][i+1][0]*grid[n-1][i];
            dp[n-1][i][1] = dp[n-1][i+1][1]*grid[n-1][i];
        }

        for (int i = n-2; i >=0 ; i--) {
            dp[i][m-1][0] = dp[i+1][m-1][0]*grid[i][m-1];
            dp[i][m-1][1] = dp[i+1][m-1][1]*grid[i][m-1];
        }

        for (int i = n-2; i >=0 ; i--) {
            for (int j = m-2; j >= 0 ; j--) {
                long a = ((dp[i+1][j][0])*(grid[i][j]));
                long b = ((dp[i+1][j][1])*(grid[i][j]));
                long c = ((dp[i][j+1][0])*(grid[i][j]));
                long d = ((dp[i][j+1][1])*(grid[i][j]));

                dp[i][j][0] = Math.max(Math.max(a,b),Math.max(c,d));
                dp[i][j][1] = Math.min(Math.min(a,b),Math.min(c,d));
            }
        }

        long res1 = dp[0][0][0]%mod;
        long res2 = dp[0][0][1]%mod;
        long res = Math.max(res1,res2);
        return (int)(res<0?-1:res);
    }
}
