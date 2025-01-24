package byteDance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(candidates.length==0)
            return res;
        Arrays.sort(candidates);
        helper(candidates,0,target,new ArrayList<Integer>(),res);
        return res;
    }
    private static void helper(int[] candidates,int start,int target,ArrayList<Integer>item,List<List<Integer>>res){
        if(target<0)
            return;
        if(target==0){
            res.add(new ArrayList<Integer>(item));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(i>0&&candidates[i]==candidates[i-1])
                continue;
            if(candidates[i]>target)
                continue;
            item.add(candidates[i]);
            helper(candidates,i,target-candidates[i],item,res);
            item.remove(item.size()-1);
        }
    }
    public static void main(String[] args){
        Solution39 s = new Solution39();
        int[] nums=new int[]{1,2,3};
        System.out.println(s.combinationSum(nums,3));
    }
}
