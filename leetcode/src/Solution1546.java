

import java.util.HashSet;
import java.util.Set;

public class Solution1546 {
    public int maxNonOverlapping(int[] nums, int target) {
        int size = nums.length;
        int i = 0;
        int ret = 0;
        while (i<size){
            Set<Integer> set = new HashSet<Integer>()
            {{add(0);}};
            set.add(0);
            int sum =0;

            while (i<size){
                sum += nums[i];
                if(set.contains(sum-target)){
                    ret++;
                    break;
                }else {
                    set.add(sum);
                    i++;
                }
            }
            i++;
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution1546 s = new Solution1546();
        int[] nums = new int[]{-2,6,6,3,5,4,1,2,8};
        System.out.println(s.maxNonOverlapping(nums,10));
    }
}
