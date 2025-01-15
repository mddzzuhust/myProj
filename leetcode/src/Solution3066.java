import java.util.PriorityQueue;

public class Solution3066 {
    public int minOperations(int[] nums, int k) {
        int res = 0;
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        for(long num : nums) {
            priorityQueue.offer(num);
        }
        while(priorityQueue.peek() < k) {
            long x = priorityQueue.poll();
            long y = priorityQueue.poll();
            priorityQueue.offer(x+x+y);
            res++;
        }
        return res;
    }
}
