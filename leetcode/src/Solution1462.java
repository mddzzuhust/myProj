public class Solution1462 {
    public double getProbability(int[] balls) {
        int n = balls.length;
        int sum = 0;
        double ans = 0;
        for(int ball : balls){
            sum += ball;
        }
        double[] fac = new double[sum+1];
        fac[0] = 1;
        for (int i = 1; i <= sum; i++) {
            fac[i] = fac[i-1]*i;
        }

        sum >>= 1;
        double[][][] dp = new double[n+1][2*n+3][sum+1];
        dp[0][n+1][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= balls[i-1]; j++) {
                for (int k = j; k <= sum; k++) {
                    for (int r = 1; r < 2*n+2; r++) {
                        if(j==0){
                            dp[i][r-1][k] += dp[i-1][r][k];
                        }else if(j == balls[i-1]){
                            dp[i][r+1][k] += dp[i-1][r][k-j];
                        }else {
                            dp[i][r][k] += dp[i-1][r][k-j] * fac[balls[i-1]] / fac[balls[i-1]-j] / fac[j];
                        }
                    }
                }
            }
        }

        ans = dp[n][n+1][sum] * fac[sum] * fac[sum];

        for (int i = 1; i <= sum*2; i++) {
            ans /= i;
        }

        return ans;
    }
}
