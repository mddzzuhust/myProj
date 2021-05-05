package leetcode;

import java.util.TreeMap;

public class Solution436 {
    public int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer, Integer> mapper = new TreeMap<>();
        int n = intervals.length;
        if (n <= 1) {
            return new int[]{-1};
        }
        for (int i = 0; i < n; i++) {
            mapper.put(intervals[i][0], i);
        }
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            Integer index = mapper.ceilingKey(intervals[i][1]);
            ret[i] = index == null ? -1 : mapper.get(index);
        }
        return ret;
    }
}
