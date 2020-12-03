package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Solution46 {
    private List<List<Integer>> res= new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return res;
        }
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        backtrack(nums, 0, list, used);
        return res;
    }

    public void backtrack(int[] nums, int index, List<Integer> list, boolean[] used) {
        if (index == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i=0; i<nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                used[i] = true;
                backtrack(nums, index+1, list, used);
                list.remove(list.size()-1);
                used[i] = false;
            }
        }
    }
}
