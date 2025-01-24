package byteDance;

public class Solution41 {
    public int firstMissingPositive(int[] nums) {
        int i=0,n=nums.length;
        if(nums==null||nums.length==0)
            return 1;
        for(i=0;i<nums.length;i++)
        {
            if(nums[i]<=nums.length && nums[i]>0 && nums[nums[i]-1]!=nums[i])
            {
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
                i--;
            }
        }
        for(i=0;i<n;i++){
            if(nums[i]!=(i+1)){
                return i+1;
            }
        }
        return n+1;
    }
    public static void main(String[] args){
        Solution41 s = new Solution41();
        int[] nums=new int[]{2,1};
        System.out.println(s.firstMissingPositive(nums));
    }
}
