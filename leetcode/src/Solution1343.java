

public class Solution1343 {
    public static void main(String[] args) {
        Solution1343 s = new Solution1343();
        int[] nums = new int[]{4,4,4,4};
        System.out.println(s.numOfSubarrays(nums,4,1));
    }

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < k; i++) {
            sum = sum + arr[i];
        }
        if (sum / k >= threshold) {
            count++;
        }

        for (int i = k; i < arr.length; i++){
            sum = sum + arr[i] - arr[i-k];
            if (sum / k >= threshold) {
                count++;
            }
        }

        return count;
    }
}
