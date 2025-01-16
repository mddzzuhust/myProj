package dynamic;

public class ZeroOneBackPack1 {
        public static int solution(int[] weights, int[] values, int bag) {
            //保证第一行，第一列为0
            int[][] dp = new int[weights.length + 1][bag + 1];
            //dp[0][0] = 0;
            for(int i=1; i<=weights.length; i++) {
                for(int j=1; j<=bag; ++j) {
                    //dp[i][j] = dp[i + 1][j];
                    //注意此处的dp的坐标与weights与values稍有差别
                    if(j >= weights[i-1]) {
                        dp[i][j] = Math.max(dp[i-1][j], values[i-1] + dp[i-1][j-weights[i-1]]);
                    }
                    //打印过程
                    System.out.print(String.format("%3d", dp[i][j]));
                    if (j == bag) {
                        System.out.println(String.format("%3d", dp[i][j]));
                    }
                }
            }
            return dp[weights.length][bag];
        }

        public static void main(String[] args) {
            System.out.println("最终结果:"+solution(new int[] {20, 30, 100}, new int[] {40, 50, 80}, 150));
        }
}
