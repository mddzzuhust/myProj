package leetcode;

import java.util.*;

public class Solution368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return new ArrayList<Integer>();

        Integer[] dp = new Integer[n];
        Arrays.sort(nums);

        Integer maxSubSetIndex = -1, maxSubSetSize = -1;

        for (int i = 0; i < n; i++) {
            Integer sudsetSize = 0;
            for (int k = 0; k < i; k++) {
                if (nums[i] % nums[k] == 0 && sudsetSize < dp[k]) {
                    sudsetSize = dp[k];
                }
            }
            dp[i] = sudsetSize + 1;
            if(maxSubSetSize < dp[i]){
                maxSubSetSize = dp[i];
                maxSubSetIndex = i;
            }
        }

        LinkedList<Integer> subset = new LinkedList<>();
        int currSize = maxSubSetSize;
        int currTail = nums[maxSubSetIndex];
        for (int i = maxSubSetIndex; i >=0 ; i--) {
            if(currSize == 0)
                break;
            if(currTail%nums[i]==0&&currSize==dp[i]){
                currSize--;
                subset.addFirst(nums[i]);
                currTail = nums[i];
            }
        }
        return subset;
    }

    public static void main(String[] args) {
        Solution368 s = new Solution368();
        int[] nums = new int[]{1,2,4,8};
        List<Integer> list = s.largestDivisibleSubset(nums);
        Iterator iterator=list.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next());
        }
    }
}
