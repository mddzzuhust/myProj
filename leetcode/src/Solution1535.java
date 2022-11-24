

public class Solution1535 {
    public int getWinner(int[] arr, int k) {
        int n = arr.length;
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (arr[0] > arr[i]){
                count++;
            }else {
                arr[0] = arr[i];
                count=1;
            }
            if(count == k){
                return arr[0];
            }
        }
        return arr[0];
    }

    public static void main(String[] args) {
        Solution1535 s = new Solution1535();
        int[] nums = new int[]{1, 11, 22, 33, 44, 55, 66, 77, 88, 99};
        System.out.println(s.getWinner(nums, 100000));
    }
}
