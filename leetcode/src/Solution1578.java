

public class Solution1578 {
    public int minCost(String s, int[] cost) {
        int n = cost.length;
        int cost_end_index = 0;
        int[] dp = new int[n];
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i)==s.charAt(i-1)){
                if(cost[cost_end_index]<cost[i]){
                    dp[i] = dp[i-1] + cost[cost_end_index];
                    cost_end_index = i;
                }else {
                    dp[i] = dp[i-1] + cost[i];

                }
            }else {
                dp[i] = dp[i-1];
                cost_end_index = i;
            }
        }
        return dp[s.length()-1];
    }

    public static void main(String[] args) {
        Solution1578 s = new Solution1578();
        String str = "aaabbbabbbb";
        int[] cost = new int[]{3,5,10,7,5,3,5,5,4,8,1};
        System.out.println(s.minCost(str,cost));
        System.out.println();
    }
}

