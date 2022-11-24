

import java.util.*;

public class Solution5517 {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        TreeSet<Integer> set = new TreeSet<>();

        int[] counts = new int[k];

        for (int i = 0; i < k; i++) {
            set.add(i);
        }

        for (int i = 0; i < arrival.length; i++) {
            while (!queue.isEmpty() && queue.peek()[1] <= arrival[i]) {
                set.add(queue.poll()[0]);
            }

            if (!set.isEmpty()) {
                Integer find = set.ceiling(i % k);
                if(find == null){
                    int num = set.first();
                    set.remove(num);
                    queue.offer(new int[]{num,arrival[i]+load[i]});
                    counts[num]++;
                }else {
                    set.remove(find);
                    queue.offer(new int[]{find,arrival[i]+load[i]});
                    counts[find]++;
                }
            }
        }
        return maxTest(counts);
    }

    private List<Integer> maxTest(int[] counts){
        int max = counts[0];
        for(int i:counts){
            max = Math.max(max,i);
        }

        List<Integer> ans = new LinkedList<>();
        for (int i = 0; i < counts.length; i++) {
            if(counts[i]==max){
                ans.add(i);
            }
        }
        return ans;
    }
}
