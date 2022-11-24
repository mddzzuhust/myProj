

import java.util.Arrays;

public class Solution1707 {
    int[][] son;
    int idx;

    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        int n = nums.length;
        son = new int[n * 31][2];
        Pair[] pair = new Pair[queries.length];
        for (int i = 0; i < queries.length; i++) {
            pair[i] = new Pair(queries[i][0], queries[i][1], i);
        }
        Arrays.sort(pair, (o1, o2) -> (o1.m - o2.m));
        int[] ans = new int[queries.length];
        int pos = 0;
        for (Pair q : pair) {
            while (pos < n && nums[pos] <= q.m) {
                insert(nums[pos]);
                pos++;
            }
            if(idx==0){
                ans[q.index] = -1;
            }else {
                int t = query(q.x);
                ans[q.index] = q.x^t;
            }
        }
        return ans;
    }

    private int query(int a) {
        int p = 0, res = 0;
        for (int i = 30; i >= 0; i--) {
            int u = a >> i & 1;
            if (son[p][u ^ 1] != 0) {
                res = res * 2 + u ^ 1;
                p = son[p][u ^ 1];
            } else {
                res = res * 2 + u;
                p = son[p][u];
            }
        }
        return res;
    }

    private void insert(int a) {
        int p = 0;
        for (int i = 30; i >= 0; i--) {
            int u = a >> i & 1;
            if(son[p][u]==0){
                son[p][u] = ++idx;
            }
            p = son[p][u];
        }
    }

    class Pair {
        int x;
        int m;
        int index;

        public Pair(int x, int m, int index) {
            this.x = x;
            this.m = m;
            this.index = index;
        }
    }
}
