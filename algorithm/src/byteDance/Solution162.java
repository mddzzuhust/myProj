package byteDance;

public class Solution162 {
    public int findPeakElement(int[] nums) {
        return Helper(nums,0,nums.length-1);
    }

    private int Helper(int[] nums,int low,int high){
        if(low==high)
            return low;
        int mid=low+(high-low)/2;
        if(nums[mid]>nums[mid+1])
            return Helper(nums,low,mid);
        else
            return Helper(nums,mid+1,high);
    }
}
