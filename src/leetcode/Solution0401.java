package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution0401 {
    public boolean findWhetherExistsPath(int n, int[][] edegs, int start, int target) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] e : edegs) {
            if (e[0] == e[1])
                continue;
            graph.computeIfAbsent(e[0], k -> new HashSet<>()).add(e[1]);
        }
        return dfs(graph, start, target);
    }

    private boolean dfs(final Map<Integer, Set<Integer>> g,
                        final int cur,
                        final int goal) {
        if (cur == goal)
            return true;
        for(int nei:g.getOrDefault(cur,new HashSet<>()))
            if(dfs(g,nei,goal))
                return true;
        return false;
    }
}
