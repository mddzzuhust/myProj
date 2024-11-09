import java.util.Arrays;

public class Solution3254 {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        Arrays.fill(ans,-1);
        for (int i = 0; i <= n-k; i++) {
            boolean valid = true;
            for (int j = i+1; j < i+k; j++) {
                if(nums[j]-nums[j-1]!=1){
                    valid = false;
                    break;
                }
            }
            if(valid){
                ans[i]=nums[i+k-1];
            }
        }
        return ans;
    }
}
