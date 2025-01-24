package byteDance;

import java.util.HashSet;

public class Solution128 {
    public int longestConsecutive(int[] nums) {
        if(nums==null||nums.length<1) return 0;
        HashSet<Integer> set=new HashSet<Integer>(nums.length);
        for(int e:nums){
            set.add(e);
        }
        int result=1;
        for(int e:nums){
            int count=1;
            int left=e-1;
            int right=e+1;
            while(set.contains(left)){
                count++;
                set.remove(left--);
            }
            while(set.contains(right)){
                count++;
                set.remove(right++);
            }
            result=Math.max(result, count);
        }
        return result;
    }
}
