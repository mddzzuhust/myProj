

import java.util.Arrays;

public class Solution1691 {
    public int maxHeight(int[][] cuboids) {
        for (int[] cuboid : cuboids) {
            Arrays.sort(cuboid);
        }
        Arrays.sort(cuboids, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return Integer.compare(o1[0], o2[0]);
            } else if (o1[1] != o2[1]) {
                return Integer.compare(o1[1], o2[1]);
            } else {
                return Integer.compare(o1[2], o2[2]);
            }
        });

        int[] dp = new int[cuboids.length];
        int maxAns = 0;
        for (int i = 0; i < cuboids.length; i++) {
            for (int j = 0; j < i; j++) {
                if(cuboids[j][1]<=cuboids[i][1]&&cuboids[j][2]<=cuboids[i][2]){
                    dp[i] = Math.max(dp[i],dp[j]);
                }
            }
            dp[i] += cuboids[i][2];
            maxAns = Math.max(maxAns,dp[i]);
        }
        return maxAns;
    }
}
