package leetcode;

import java.util.Arrays;

public class Solution1547 {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;

        Arrays.sort(cuts);
        int[] newCuts = new int[m+2];
        int[][] f = new int[m+2][m+2];

        newCuts[0] = 0;
        newCuts[m+1] = n;
        for (int i = 1; i <= cuts.length; i++) {
            newCuts[i] = cuts[i-1];
        }

        for (int i = m; i >=1 ; i--) {
            for (int j = i; j <=m ; j++) {
                f[i][j] = i==j?0:Integer.MAX_VALUE;
                for (int k = i; k <=j ; k++) {
                    f[i][j] = Math.min(f[i][j],f[i][k-1]+f[k+1][j]);
                }
                f[i][j] += newCuts[j+1]-newCuts[i-1];
            }
        }
        return f[1][m];
    }

    public static void main(String[] args) {
        Solution1547 s = new Solution1547();
        int[] cuts = new int[]{5,6,1,4,2};
        System.out.println(s.minCost(9,cuts));
    }
}
