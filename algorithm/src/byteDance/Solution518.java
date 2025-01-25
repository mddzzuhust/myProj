package byteDance;

public class Solution518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        boolean[] valid = new boolean[amount + 1];
        dp[0] = 1;
        valid[0] = true;
        for(int coin : coins){
            for(int i=coin; i<=amount; i++){
                valid[i] |= valid[i-coin];
            }
        }
        if(!valid[amount]){
            return 0;
        }
        for(int coin:coins){
            for(int i=coin;i<=amount;i++){
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }
}
