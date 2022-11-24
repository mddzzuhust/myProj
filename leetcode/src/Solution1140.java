

public class Solution1140 {
    public int stoneGameII(int[] piles) {
        int len = piles.length;
        int[][] dp = new int[len][len + 1];
        int sum = 0;
        for (int i = len - 1; i >= 0; i--) {
            sum += piles[i];
            for (int M = 1; M <=len ; M++) {
                if(i+2*M>len){
                    dp[i][M] = sum;
                }else{
                    for(int x=1;x<=2*M;x++){
                        dp[i][M] = Math.max(dp[i][M],sum-dp[i+x][Math.max(x,M)]);
                    }
                }
            }
        }
        return dp[0][1];
    }

    public static void main(String[] args) {
        Solution1140 s = new Solution1140();
        int[] piles = new int[]{2,7,9,4,4};
        System.out.println(s.stoneGameII(piles));
    }
}
