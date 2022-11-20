package leetcode;

public class Solution808 {
    public double soupServings(int N) {
        int count = N / 25 + (N % 25 > 0 ? 1 : 0);
        if (count >= 500)
            return 1.0;

        double[][] dp = new double[count + 1][count + 1];
        dp[0][0] = 0.5;
        for (int i = 1; i <= count; i++) {
            dp[0][i] = 1;
            dp[i][0] = 0;
        }

        for (int i = 1; i <= count; i++) {
            int a1 = i - 4 > 0 ? i - 4 : 0;
            int a2 = i - 3 > 0 ? i - 3 : 0;
            int a3 = i - 2 > 0 ? i - 2 : 0;
            int a4 = i - 1 > 0 ? i - 1 : 0;

            for (int j = 1; j <= count; j++) {
                int b1 = j;
                int b2 = j - 1 > 0 ? j - 1 : 0;
                int b3 = j - 2 > 0 ? j - 2 : 0;
                int b4 = j - 3 > 0 ? j - 3 : 0;

                dp[i][j] = 0.25 * (dp[a1][b1] + dp[a2][b2] + dp[a3][b3] + dp[a4][b4]);
            }
        }
        return dp[count][count];
    }

    public static void main(String[] args) {
        Solution808 s = new Solution808();
        System.out.println(s.soupServings(50));
    }
}
