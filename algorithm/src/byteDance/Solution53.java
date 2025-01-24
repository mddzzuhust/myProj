package byteDance;

public class Solution53 {
    public int maxSubArray(int[] nums) {
        int sum=0,max_sum=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(sum<0) sum=0;
            sum=sum+nums[i];
            if(sum>max_sum){
                max_sum=sum;
            }
        }
        return max_sum;
    }
}
