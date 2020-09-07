package leetcode;

public class Solution312 {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] rec = new int[n+2][n+2];
        int[] val = new int[n+2];

        for (int i = 1; i <= nums.length; i++) {
            val[i] = nums[i-1];
        }

        val[0]=val[n+1]=1;

        for (int i = n-1; i >=0 ; i--) {
            for (int j = i+2; j <= n+1; j++) {
                for (int k = i+1; k < j; k++) {
                    int sum = val[i]*val[k]*val[j];
                    sum += rec[i][k]+rec[k][j];
                    rec[i][j] = Math.max(rec[i][j],sum);
                }
            }
        }
        return rec[0][n+1];
    }

    public static void main(String[] args) {
        Solution312 s = new Solution312();
        int[] nums = new int[]{3,1,5,8};
        System.out.println(s.maxCoins(nums));
    }
}
