public class Solution287 {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        int ptr = 0;
        while (ptr != slow) {
            ptr = nums[ptr];
            slow = nums[slow];
        }
        return ptr;
    }

    public static void main(String[] args) {
        Solution287 solution287 = new Solution287();
        System.out.println(solution287.findDuplicate(new int[]{3,1,3,4,2}));
    }
}
