package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution1617 {
    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }
        int[] dp = new int[1 << (n)];
        for (int[] edge : edges) {
            dist[edge[0] - 1][edge[1] - 1] = 1;
            dist[edge[1] - 1][edge[0] - 1] = 1;
            dp[(1 << (edge[0] - 1)) + (1 << (edge[1] - 1))] = 1;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        for (int j = 1; j < dp.length; j++) {
            if (dp[j] == 0)
                continue;
            for (int i = 0; i < n; i++) {
                if (((1 << i) & j) != 0 || dp[j + (1 << i)] != 0)
                    continue;
                for (int k = 0; k < n; k++) {
                    if (((1 << k) & j) != 0 && dist[i][k] == 1) {
                        dp[j + (1 << i)] = dp[j];
                        break;
                    }
                }
                if (dp[j + (1 << i)] == 0)
                    continue;
                for (int kk = 0; kk < n; kk++) {
                    if (((1 << kk) & j) != 0) {
                        dp[j + (1 << i)] = Math.max(dp[j + (1 << i)], dist[i][kk]);
                    }
                }
            }
        }
        int[] ans = new int[n - 1];
        for (int j = 0; j < dp.length; j++) {
            if (dp[j] != 0)
                ans[dp[j] - 1]++;
        }
        return ans;
    }
}
