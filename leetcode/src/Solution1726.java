

import java.util.HashMap;
import java.util.Map;

public class Solution1726 {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int tmp = nums[i] * nums[j];
                map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            }
        }

        int res = 0;
        for (Integer key : map.keySet()) {
            int count = map.get(key);
            res = res + count*(count-1)*4;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution1726 s = new Solution1726();
        int[] nums = new int[]{2,3,4,6,8,12};
        System.out.println(s.tupleSameProduct(nums));
    }
}
