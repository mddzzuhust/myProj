import java.util.Arrays;

public class Solution3065 {
    public int minOperations(int[] nums, int k) {
        int count = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < k){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution3065 solution = new Solution3065();
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
        System.out.println(solution.minOperations(nums, 3));
    }
}
