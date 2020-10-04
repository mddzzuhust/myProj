package leetcode;

public class Solution5518 {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int row = rowSum.length;
        int col = colSum.length;

        int[][] ans = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ans[i][j] = Math.min(rowSum[i],colSum[j]);
                rowSum[i] = rowSum[i]-ans[i][j];
                colSum[j] = colSum[j]-ans[i][j];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution5518 s = new Solution5518();
        int[] rowSum = new int[]{5,7,10};
        int[] colSum = new int[]{8,6,8};
        int[][] ans = s.restoreMatrix(rowSum,colSum);

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.printf(ans[i][j]+" ");
            }
            System.out.println();
        }
    }
}
