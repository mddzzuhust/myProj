package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Solution1235 {
    class jobs {
        int start, end, profit;

        jobs(int s, int e, int p) {
            this.start = s;
            this.end = e;
            this.profit = p;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[] dp = new int[n+1];
        jobs[] job = new jobs[n];
        for (int i = 0; i < n; i++) {
            job[i] = new jobs(startTime[i],endTime[i],profit[i]);
        }
        Arrays.sort(job, Comparator.comparingInt(o->o.end));
        for (int i = 0; i < n; i++) {
            dp[i] = job[i].profit;
        }
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i-1],job[i].profit);
            for (int j = i-1; j >= 0; j--) {
                if(job[j].end<=job[i].start){
                    dp[i] = Math.max(dp[i],dp[j]+job[i].profit);
                    break;
                }
            }
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        Solution1235 s = new Solution1235();
        int[] startTime = new int[]{1,2,3,3};
        int[] endTime = new int[]{3,4,5,6};
        int[] profit = new int[]{50,10,40,70};
        System.out.println(s.jobScheduling(startTime,endTime,profit));
    }
}
