package byteDance;

public class Solution209 {
    public int minSubArrayLen(int s,int[] nums){
        int start=0;
        int end=0;

        int sum=0;
        int min=Integer.MAX_VALUE;
        while(start<nums.length&&end<nums.length){
            while(sum<s&&end<nums.length){
                sum+=nums[end++];
            }
            while(sum>=s&&start<=end){
                min=Math.min(min, end-start);
                sum-=nums[start++];
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}
