

import java.util.PriorityQueue;

public class Solution17_14 {
    public int[] smallestK(int[] arr, int k) {
        if(arr.length==0||arr==null){
            return new int[k];
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            queue.offer(arr[i]);
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] num = new int[]{1,3,5,7,2,4,6,8};
        Solution17_14 s = new Solution17_14();
        int[] result = s.smallestK(num,4);
        System.out.println("\n");
    }
}
