import java.util.Arrays;

public class Solution3180 {
    public int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);
        int m = rewardValues[rewardValues.length-1];
        int[] dp = new int[2*m];
        dp[0] = 1;
        for(int x : rewardValues){
            for(int k = 2*x-1;k>=x;k--){
                if(dp[k-x]==1){
                    dp[k] = 1;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            if(dp[i]==1){
                res=i;
            }
        }
        return res;
    }
}
