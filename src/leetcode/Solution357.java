package leetcode;

public class Solution357 {
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0)
            return 1;
        int[] dp = new int[n+1];
        dp[0] = 0;dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1]*10+(9*(int)Math.pow(10,i-2)-dp[i-1])*(i-1);
        }
        int sum = 0;
        for(int i = 0;i<=n;i++){
            sum = sum + dp[i];
        }
        return (int)Math.pow(10,n)-sum;
    }
    public static void main(String[] args) {
        Solution357 solution357 = new Solution357();
        System.out.println(solution357.countNumbersWithUniqueDigits(2));
    }
}
