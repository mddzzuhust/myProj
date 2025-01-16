package dfs;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        boolean[] used = new boolean[nums.length];
        dfs(nums, new ArrayList<>(), used, result);
        return result;
    }

    private void dfs(int[] nums, List<Integer> item, boolean[] used, List<List<Integer>> result) {
        // 当item的大小达到nums的长度时，表明找到了一个全排列
        if (item.size() == nums.length) {
            result.add(new ArrayList<>(item));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                item.add(nums[i]);
                dfs(nums, item, used, result);
                used[i] = false;
                item.remove(item.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = permutations.permute(nums);
        // 打印全排列结果
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
