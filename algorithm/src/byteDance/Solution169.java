package byteDance;

public class Solution169 {
    public int majorityElement(int[] nums) {
        if(nums.length==0) return 0;
        int count=1;
        int majority_number=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]==majority_number){
                count++;
            }else if(count==0){
                majority_number=nums[i];
            }else{
                count--;
            }
        }
        return majority_number;
    }
}
