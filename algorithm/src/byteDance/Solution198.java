package byteDance;

public class Solution198 {
    public int rob(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        int n=nums.length;

        int[] b=new int[n];
        int[] d=new int[n];

        b[0]=nums[0];
        d[0]=0;

        for(int i=1;i<n;i++){
            b[i]=d[i-1]+nums[i];
            d[i]=Math.max(b[i-1],d[i-1]);
        }
        return Math.max(d[n-1],b[n-1]);
    }
}
