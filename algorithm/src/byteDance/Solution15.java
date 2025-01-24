package byteDance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret=new ArrayList<List<Integer>>();
        int i=0;
        if(nums.length<=2) return ret;
        Arrays.sort(nums);
        while(i<nums.length-2){
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                if(nums[i]+nums[j]+nums[k]<0){
                    j++;
                }
                else if(nums[i]+nums[j]+nums[k]>0){
                    k--;
                }
                else{
                    ret.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;k--;
                    while(j<k&&nums[j]==nums[j-1]) j++;
                    while(j<k&&nums[k]==nums[k+1]) k--;
                }

            }
            while(nums[i]==nums[i+1]&&i<nums.length-2) i++;
            i++;
        }
        return ret;
    }
    public static void main(String[] args)
    {
        Solution15 s=new Solution15();
        int[] nums={-1,0,1,2,-1,-4};
        System.out.println(s.threeSum(nums));
    }
}
