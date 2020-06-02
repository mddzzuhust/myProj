public class Solution10_03 {
    public int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length-1;

        while (left<right){
            int mid = left + (right-left)/2;
            if(arr[left]<arr[mid]){
                if(arr[left]<=target&&target<=arr[mid]){
                    right = mid;
                }else {
                    left = mid+1;
                }
            }else if(arr[left]>arr[mid]){
                if(arr[left]<=target||target<=arr[mid]){
                    right = mid;
                }else {
                    left = mid+1;
                }
            }else if(arr[left]==arr[mid]){
                if(target != arr[left]){
                    left++;
                }else{
                    right = left;
                }
            }
        }
        if(arr[left]==target){
            return left;
        }else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution10_03 solution10_03 = new Solution10_03();
        int[] arr = {5,5,5,1,2,3,4,5};
        int target = 5;
        System.out.println(solution10_03.search(arr,target));
    }
}
