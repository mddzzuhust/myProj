package byteDance;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k==0)
            return nums;
        int len=nums.length;
        int[] rst=new int[len-k+1];
        PriorityQueue<Integer> priorityQueue=
                new PriorityQueue<Integer>(k,new Comparator<Integer>(){
                    @Override
                    public int compare(Integer o1,Integer o2){
                        return o1<o2?1:(o1>o2?-1:0);
                    }
                });
        for(int i=0;i<k-1;i++){
            priorityQueue.offer(nums[i]);
        }
        for(int i=0;i<len-k+1;i++){
            priorityQueue.offer(nums[i+k-1]);
            rst[i]=priorityQueue.peek();
            priorityQueue.remove(nums[i]);
        }
        return rst;
    }
}
