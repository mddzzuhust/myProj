public class Solution2275 {
    public int largestCombination(int[] candidates) {
        int res = 0;
        for (int i = 0; i < 24; i++) {
            res = Math.max(res, maxLen(candidates, i));
        }
        return res;
    }

    public int maxLen(int[] candidates, int k) {
        int res = 0;
        for(int num : candidates) {
            if((num & (1<<k)) != 0) {
                res++;
            }
        }
        return res;
    }
}
