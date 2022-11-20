package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution1590 {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        long v = sum % p;
        if (v == 0)
            return 0;
        long[] prefixSum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        int min = Integer.MAX_VALUE;
        Map<Long,Integer> prefixSumMap = new HashMap<>();

        for (int i = 0; i <= n; i++) {
            Integer index = prefixSumMap.get((prefixSum[i]-v)%p);
            if(index!=null){
                min = Math.min(min,i-index);
            }
            prefixSumMap.merge(prefixSum[i]%p,i,Math::max);
        }
        return (min==Integer.MAX_VALUE||min==n)?-1:min;
    }

    public static void main(String[] args) {
        Solution1590 s= new Solution1590();
        int[] nums = new int[]{1,2,3};
        System.out.println(s.minSubarray(nums,3));
    }
}
