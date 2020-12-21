package leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Solution1697 {
    class UnionFind {
        int[] group;

        UnionFind(int n) {
            this.group = new int[n];
            for (int i = 0; i < n; i++) {
                group[i] = i;
            }
        }

        public int find(int x) {
            if (x != group[x]) {
                group[x] = find(group[x]);
            }
            return group[x];
        }

        public void union(int i, int j) {
            int pi = find(i);
            int pj = find(j);
            if (pi == pj)
                return;
            group[pi] = pj;
        }
    }

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        TreeMap<int[], Integer> map = new TreeMap<>((o1, o2) -> o1[2] != o2[2] ? o1[2] - o2[2] : 1);
        for (int i = 0; i < queries.length; i++) {
            map.put(queries[i], i);
        }
        Arrays.sort(edgeList, (o1, o2) -> o1[2] - o2[2]);
        boolean[] ans = new boolean[queries.length];
        UnionFind uf = new UnionFind(n);
        int index = 0;
        while (!map.isEmpty()) {
            Map.Entry<int[], Integer> curr = map.pollFirstEntry();
            int[] q = curr.getKey();
            int in = curr.getValue();
            for (; index < edgeList.length && edgeList[index][2] < q[2]; ) {
                uf.union(edgeList[index][0], edgeList[index][1]);
                index++;
            }
            ans[in] = (uf.find(q[0]) == uf.find(q[1]));
        }
        return ans;
    }
}
