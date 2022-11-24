

public class Solution464 {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(maxChoosableInteger>=desiredTotal) return true;
        if((1+maxChoosableInteger)*maxChoosableInteger/2<desiredTotal) return false;

        Boolean[] dp = new Boolean[(1<<maxChoosableInteger)-1];

        return dfs(maxChoosableInteger,desiredTotal,0,dp);
    }

    private boolean dfs(int maxChoosableInteger, int desiredTotal, int state, Boolean[] dp){
        if(dp[state]!=null)
            return dp[state];

        for (int i = 1; i <= maxChoosableInteger; i++) {
            int tmp = 1<<(i-1);
            if((tmp&state)==0){
                if(desiredTotal-i<=0||!dfs(maxChoosableInteger,desiredTotal-i,tmp|state,dp)){
                    dp[state]=true;
                    return true;
                }
            }
        }
        dp[state]=false;
        return false;
    }

    public static void main(String[] args) {
        Solution464 s = new Solution464();
        System.out.println(s.canIWin(10,11));
    }
}
