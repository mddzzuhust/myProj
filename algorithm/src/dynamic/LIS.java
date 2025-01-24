package dynamic;

import java.util.Scanner;
/**
 * LIS（Longest Increasing Subsequence）最长上升（不下降）子序列
 */
public class LIS {
    public static void main(String[] args) {
        LIS lis = new LIS();
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(lis.lengthOfLIS(nums));
    }
    public int lengthOfLIS(int[] nums){
        int length = nums.length;
        if(length == 0){
            return 0;
        }
        int curlength = 0;
        int[] result = new int[length+1];
        result[0]=Integer.MIN_VALUE;
        for(int i=0; i<length;i++){
            int pre = binarySearch(result,0,curlength,nums[i]);
            if(nums[i]==result[pre]){
                continue;
            }
            pre++;
            result[pre]=nums[i];
            if(pre > curlength){
                curlength = pre;
            }
        }
        return curlength;
    }

    private int binarySearch(int[] result, int l, int r, int num){
        while(l<=r){
            int mid = (l+r)/2;
            if(num<result[mid]){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return r;
    }
}