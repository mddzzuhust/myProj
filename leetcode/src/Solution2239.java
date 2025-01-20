public class Solution2239 {
    public int findClosestNumber(int[] nums) {
        int dis = Math.abs(nums[0]);
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(dis > Math.abs(nums[i])) {
                max = nums[i];
                dis = Math.abs(nums[i]);
            }else if(dis == Math.abs(nums[i])) {
                if(max < nums[i]) {
                    max = nums[i];
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,-1,1};
        Solution2239 s = new Solution2239();
        System.out.println(s.findClosestNumber(nums));
    }
}
