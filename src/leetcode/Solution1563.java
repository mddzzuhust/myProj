package leetcode;

public class Solution1563 {
    public int stoneGameV(int[] stoneValue) {
        int N = stoneValue.length;
        int[][] dp = new int[N][N];
        int[] preSum = new int[N];

        preSum[0] = stoneValue[0];
        for (int i = 1; i < N; i++) {
            preSum[i] = stoneValue[i]+preSum[i-1];
        }

        for (int len = 2; len <= N; len++) {
            for (int i = 0; i+len-1 < N; i++) {
                int j = i+len-1;
                for (int m = i; m <= j; m++) {
                    if(i>m||m+1>j)
                        continue;
                    int l = dp[i][m];
                    int r = dp[m+1][j];
                    int ls = preSum[m]-(i>0?preSum[i-1]:0);
                    int rs = preSum[j]-preSum[m];

                    if(ls==rs){
                        int score = Math.max(l,r)+ls;
                        dp[i][j] = Math.max(dp[i][j],score);
                    }else {
                        if(ls>rs){
                            dp[i][j] = Math.max(dp[i][j],r+rs);
                        }else {
                            dp[i][j] = Math.max(dp[i][j],l+ls);
                        }
                    }
                }
            }
        }
        return dp[0][N-1];
    }

    public static void main(String[] args) {
        Solution1563 s = new Solution1563();
        int[] stoneValue = new int[]{4};
        System.out.println(s.stoneGameV(stoneValue));
    }
}
