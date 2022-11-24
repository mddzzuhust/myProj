

import java.util.Arrays;

public class Solution1144 {
    public static void main(String[] args) {
        Solution1144 s = new Solution1144();
        int[] nums = new int[]{2,7,10,9,8,9};
        System.out.println(s.movesToMakeZigzag(nums));
    }

    public int movesToMakeZigzag(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int[] nums1 = Arrays.copyOf(nums, nums.length);
        int count = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            if (i == 0) {
                if (nums[i] <= nums[i + 1]) {
                    count = count + nums[i + 1] - nums[i] + 1;
                    nums[i + 1] = nums[i] - 1;
                }
                continue;
            }
            if (i == nums.length - 1) {
                if (nums[i] <= nums[i - 1]) {
                    count = count + nums[i - 1] - nums[i] + 1;
                    nums[i - 1] = nums[i] - 1;
                }
                break;
            }

            if (nums[i - 1] >= nums[i] && nums[i] >= nums[i + 1]) {
                count = count + nums[i - 1] - nums[i] + 1;
                nums[i - 1] = nums[i] - 1;
                if (nums[i] == nums[i + 1]) {
                    count = count + 1;
                    nums[i + 1] = nums[i] - 1;
                }
            } else if (nums[i - 1] <= nums[i] && nums[i] <= nums[i + 1]) {
                count = count + nums[i + 1] - nums[i] + 1;
                nums[i + 1] = nums[i] - 1;
                if (nums[i] == nums[i - 1]) {
                    count = count + 1;
                    nums[i - 1] = nums[i] - 1;
                }
            } else if (nums[i - 1] >= nums[i] && nums[i + 1] >= nums[i]) {
                count = count + nums[i - 1] - nums[i] + 1;
                nums[i - 1] = nums[i] - 1;
                count = count + nums[i + 1] - nums[i] + 1;
                nums[i + 1] = nums[i] - 1;
            }
        }

        int count1 = 0;
        for (int i = 1; i < nums1.length; i = i + 2) {

            if (i == nums1.length - 1) {
                if (nums1[i] <= nums1[i - 1]) {
                    count1 = count1 + nums1[i - 1] - nums1[i] + 1;
                    nums1[i - 1] = nums1[i] - 1;
                }
                break;
            }

            if (nums1[i - 1] >= nums1[i] && nums1[i] >= nums1[i + 1]) {
                count1 = count1 + nums1[i - 1] - nums1[i] + 1;
                nums1[i - 1] = nums1[i] - 1;
                if (nums1[i] == nums1[i + 1]) {
                    count1 = count1 + 1;
                    nums1[i + 1] = nums1[i] - 1;
                }
            } else if (nums1[i - 1] <= nums1[i] && nums1[i] <= nums1[i + 1]) {
                count1 = count1 + nums1[i + 1] - nums1[i] + 1;
                nums1[i + 1] = nums1[i] - 1;
                if (nums1[i] == nums1[i - 1]) {
                    count1 = count1 + 1;
                    nums1[i - 1] = nums1[i] - 1;
                }
            } else if (nums1[i - 1] >= nums1[i] && nums1[i + 1] >= nums1[i]) {
                count1 = count1 + nums1[i - 1] - nums1[i] + 1;
                nums1[i - 1] = nums1[i] - 1;
                count1 = count1 + nums1[i + 1] - nums1[i] + 1;
                nums1[i + 1] = nums1[i] - 1;
            }
        }

        return Math.min(count, count1);
    }
}
