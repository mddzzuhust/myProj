package leetcode;

public class Solution1248 {
    public int numberOfSubarrays(int[] nums, int k) {
        int start = 0, end = 0;
        int leftcnt = 0, rightcnt = 0;
        int count = 0;
        int result = 0;
        while (end<nums.length){
            if((nums[end]&1)==1){
                count++;
            }
            end++;
            if(count==k){
                int tmp = end;
                while (end<nums.length&&(nums[end]&1)==0){
                    rightcnt++;
                    end++;
                }
                rightcnt = end-tmp;
                leftcnt = 0;
                while (start<end&&(nums[start]&1)==0){
                    leftcnt++;
                    start++;
                }
                result = result + (leftcnt+1)*(rightcnt+1);
                start++;
                count--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution1248 s = new Solution1248();
        int[] nums = new int[]{2,2,2,1,2,2,1,2,2,2};
        System.out.println(s.numberOfSubarrays(nums,2));
    }
}
