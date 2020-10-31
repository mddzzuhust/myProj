package leetcode;

import Greedy.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1630 {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> list = new ArrayList<>();
        int lennums = nums.length;
        int lenm = l.length;
        int[] result = new int[lennums+1];
        for (int i = 0; i < lenm; i++) {
            for (int j = l[i]; j <= r[i]; j++) {
                result[j] = nums[j];
            }
            Arrays.sort(result,l[i],r[i]+1);
            int num = result[l[i]+1]-result[l[i]];
            boolean flag = true;
            for (int j = l[i]+1; j <= r[i] ; j++) {
                if(result[j]-result[j-1]!=num){
                    list.add(new Boolean(false));
                    flag = false;
                    break;
                }
            }
            if(flag == true){
                list.add(new Boolean(true));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Solution1630 s = new Solution1630();
        int[] nums = new int[]{-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10};
        int[] l = new int[]{0,1,6,4,8,7};
        int[] r = new int[]{4,4,9,7,9,10};
        System.out.println(s.checkArithmeticSubarrays(nums,l,r));
    }
}
