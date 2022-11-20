package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution1733 {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;
        boolean[] p = new boolean[m + 1];
        Set<Integer>[] set = new Set[n + 1];
        for (int i = 0; i < n + 1; i++) {
            set[i] = new HashSet<>();
        }
        for (int[] friend : friendships) {
            int u = friend[0];
            int v = friend[1];
            Set<Integer> tmp = new HashSet<>();
            boolean flag = false;
            for (int k : languages[u - 1]) {
                tmp.add(k);
            }
            for (int k : languages[v - 1]) {
                if(tmp.contains(k)){
                    flag = true;
                    break;
                }
            }
            if (flag)
                continue;
            if (!p[u]) {
                p[u] = true;
                for (int k : languages[u - 1]) {
                    set[k].add(u);
                }
            }
            if (!p[v]) {
                p[v] = true;
                for (int k : languages[v - 1]) {
                    set[k].add(v);
                }
            }
        }
        int ans = m;
        int num = 0;
        for (int i = 1; i < m + 1; i++) {
            if (p[i]) {
                num++;
            }
        }
        for (int i = 1; i < n + 1; i++) {
            ans = Math.min(ans, num - set[i].size());
        }
        return ans;
    }
}
