public class Solution3171 {
    public int minimumDifference(int[] nums, int k) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            ans = Math.min(ans, Math.abs(x-k));
            for (int j = i-1; j >= 0 && (nums[j]|x) != nums[j];j--){
                nums[j] |= x;
                ans = Math.min(ans, Math.abs(nums[j]-k));
            }
        }
        return ans;
    }
}
