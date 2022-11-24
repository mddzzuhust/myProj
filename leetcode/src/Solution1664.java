

public class Solution1664 {
    public int waysToMakeFair(int[] nums) {
        int n = nums.length;
        int[] odd = new int[n];
        int[] even = new int[n];

        even[0] = nums[0];
        odd[0] = 0;
        for (int i = 1; i < n; i++) {
            if (i % 2 == 0) {
                even[i] = even[i - 1] + nums[i];
                odd[i] = odd[i - 1];
            } else {
                even[i] = even[i - 1];
                odd[i] = odd[i - 1] + nums[i];
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int left_odd = i - 1 >= 0 ? odd[i - 1] : 0;
            int left_even = i - 1 >= 0 ? even[i - 1] : 0;

            int right_odd = odd[n - 1] - odd[i];
            int right_even = even[n - 1] - even[i];

            int tmp = right_even;
            right_even = right_odd;
            right_odd = tmp;

            if(left_even+right_even==left_odd+right_odd){
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution1664 s = new Solution1664();
        int[] nums = new int[]{1,2,3};
        System.out.println(s.waysToMakeFair(nums));
    }
}
