package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution1723 {
    int[] man;
    int ans = 0;

    public int minimumTimeRequired(int[] jobs, int k) {
        Queue<Integer> que = new PriorityQueue<>();
        int t = 0;
        man = new int[k];
        Arrays.sort(jobs);
        for (int i = 0; i < k; i++) {
            que.offer(0);
        }
        for (int i = jobs.length - 1; i >= 0; i--) {
            que.offer(jobs[i] + que.poll());
        }
        while (!que.isEmpty()) {
            ans = que.poll();
        }
        dfs(jobs, k, jobs.length - 1, man);
        return ans;
    }

    public void dfs(int[] jobs, int k, int x, int[] man) {
        if (x == -1) {
            int max = 0;
            for (int i = 0; i < k; i++) {
                max = Math.max(max, man[i]);
            }
            ans = Math.min(ans, max);
            return;
        }

        int[] tem = new int[k];
        for (int i = 0; i < k; i++) {
            tem[i] = man[i];
        }

        Arrays.sort(tem);

        for (int i = 0; i < k; i++) {
            if ((i == 0 || tem[i] != tem[i - 1]) && (tem[i] + jobs[x] < ans)) {
                tem[i] += jobs[x];
                dfs(jobs, k, x - 1, tem);
                tem[i] -= jobs[x];
            }
        }
        return;
    }
}
