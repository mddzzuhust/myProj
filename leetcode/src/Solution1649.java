

import java.util.*;

public class Solution1649 {
    public int createSortedArray(int[] instructions) {
        int mod = (int) 1e9 + 7;
        long ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < instructions.length; i++) {
            set.add(instructions[i]);
        }
        int[] nums = new int[set.size()];
        int index = 0;
        for (int num : set) {
            nums[index++] = num;
        }
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i + 1);
        }
        BIT bit = new BIT(nums.length);

        for (int i = 0; i < instructions.length; i++) {
            int t = map.get(instructions[i]);
            int l = bit.getSum(t - 1);
            int r = bit.getSum(t);
            ans += Math.min(l, i - r);
            ans %= mod;
            bit.update(t,1);
        }
        return (int)ans;
    }

    class BIT {
        int n;
        int[] tree;

        public BIT(int n) {
            this.n = n;
            tree = new int[n + 1];
        }

        public void update(int i, int val) {
            while (i <= n) {
                tree[i] += val;
                i += lowbit(i);
            }
        }

        public int getSum(int i) {
            int res = 0;
            while (i > 0) {
                res += tree[i];
                i -= lowbit(i);
            }
            return res;
        }

        public int lowbit(int x) {
            return x & (-x);
        }
    }
}
