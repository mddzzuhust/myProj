package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution5495 {
    public List<Integer> mostVisited(int n, int[] rounds) {
        int[] nums = new int[n+1];
        nums[rounds[0]]++;
        for (int i = 0; i < rounds.length-1; i++) {
            if(rounds[i+1]>rounds[i]){
                for (int j = rounds[i]+1; j <= rounds[i+1]; j++) {
                    nums[j]++;
                }
            }else {
                for (int j = rounds[i]+1; j <= rounds[i+1]+n; j++) {
                    if(j<=n){
                        nums[j]++;
                    }else {
                        nums[j-n]++;
                    }
                }
            }
        }
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>max){
                max = nums[i];
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==max) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution5495 s = new Solution5495();
        int[] rounds = new int[]{1,3,5,7};
        int n = 7;
        System.out.println(s.mostVisited(n,rounds));
        System.out.println();
    }
}
