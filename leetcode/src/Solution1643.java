

public class Solution1643 {
    public String kthSmallestPath(int[] destination, int k) {
        int rows = destination[0];
        int cols = destination[1];
        int h = cols;
        int v = rows;
        StringBuffer sb = new StringBuffer();
        int[][] dp = new int[h + v][h];
        dp[0][0] = 1;
        for (int i = 1; i < h + v; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= i && j < h; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
        while (h > 0 && v > 0) {
            int low = dp[h + v - 1][h - 1];
            if (k > low) {
                sb.append("V");
                v--;
                k-=low;
            }else {
                sb.append("H");
                h--;
            }
        }
        if(h==0){
            for (int i = 0; i < v; i++) {
                sb.append("V");
            }
        }else {
            for (int i = 0; i < h; i++) {
                sb.append("H");
            }
        }
        return sb.toString();
    }
}
