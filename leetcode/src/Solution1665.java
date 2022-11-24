

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1665 {
    class Help {
        int cost;
        int need;

        public Help(int cost, int need) {
            this.cost = cost;
            this.need = need;
        }
    }

    public int minimumEffort(int[][] tasks) {
        PriorityQueue<Help> pq = new PriorityQueue<>(tasks.length, new Comparator<Help>() {
            @Override
            public int compare(Help o1, Help o2) {
                return (o2.need - o2.cost) - (o1.need - o1.cost);
            }
        });

        for (int[] i : tasks) {
            pq.add(new Help(i[0], i[1]));
        }

        int count = 0;
        int cur = 0;
        while (!pq.isEmpty()) {
            Help h = pq.poll();
            if (cur < h.need) {
                count += h.need - cur;
                cur = h.need - h.cost;
            } else {
                cur = cur - h.cost;
            }
        }
        return count;
    }
}
