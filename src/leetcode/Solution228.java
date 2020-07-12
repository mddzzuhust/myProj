package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> res=new ArrayList<>();
        if(nums==null||nums.length<1)
            return res;

        int s=0,e=0;
        while(e<nums.length){
            if(e+1<nums.length&&nums[e+1]==nums[e]+1){
                e++;
            }else{
                if(s==e){
                    res.add(Integer.toString(nums[s]));
                }else{
                    String str=nums[s]+"->"+nums[e];
                    res.add(str);
                }
                ++e;
                s=e;
            }
        }
        return res;
    }
    public static void main(String[] args){
        Solution228 s=new Solution228();
        int[] nums=new int[]{1,0,1,1};
        //System.out.println(s.containsNearbyDuplicate(nums, 1));
    }
}
