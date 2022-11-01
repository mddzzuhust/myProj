package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Solution452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] point1, int[] point2) {
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] < point2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        int pos = points[0][1];
        int ans = 1;
        for (int[] ballon : points) {
            if (ballon[0] > pos) {
                pos = ballon[1];
                ans++;
            }
        }
        return ans;
    }
}
