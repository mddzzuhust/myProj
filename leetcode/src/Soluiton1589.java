

import java.util.Arrays;

public class Soluiton1589 {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int n = nums.length;
        //构建一个差分数组
        int[] diff = new int[n+1];
        for(int[] r : requests){
            diff[r[0]]++;
            diff[r[1]+1]--;
        }
        //找到元素的累加和，即为元素出现的频率
        for(int i = 0;i < n;i++){
            diff[i+1] += diff[i];
        }
        diff = Arrays.copyOf(diff, n);
        //如果要求出最大的和
        //那么就是nums数组大数*diff数组对应的高频率
        //因此对两个数组进行排序，最后两两相乘累加即可
        Arrays.sort(diff);
        Arrays.sort(nums);
        long ans = 0;
        int mod = 1000000007;
        for(int i = 0;i < n;i++){
            ans += (long)diff[i] * nums[i];
            ans %= mod;
        }
        return (int)ans;
    }
}
