package byteDance;

public class Solution31 {
    public void nextPermutation(int[] nums) {
        int i=nums.length-1;
        while(i>0&&nums[i]<=nums[i-1]){
            i--;
        }
        if(i>0){
            int j=nums.length-1;
            while(nums[j]<=nums[i-1]){
                j--;
            }
            int tmp=nums[i-1];
            nums[i-1]=nums[j];
            nums[j]=tmp;
        }
        int j=nums.length-1;
        while(i<j){
            int tmp=nums[i];
            nums[i]=nums[j];
            nums[j]=tmp;
            i++;j--;
        }
        for(i=0;i<nums.length;i++)
            System.out.print(nums[i]+" ");
    }
    public static void main(String[] args){
        Solution31 s = new Solution31();
        int[] nums=new int[]{1,2};
        s.nextPermutation(nums);
    }
}
