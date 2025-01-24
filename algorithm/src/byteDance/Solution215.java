package byteDance;

public class Solution215 {
    public int findKthLargest(int[] nums,int k){
        return findK(nums,nums.length-k,0,nums.length-1);
    }

    private int findK(int[] nums,int k,int i,int j){
        if(i>=j) return nums[i];
        int m=partition(nums,i,j);
        if(m==k) return nums[m];
        else if(m<k){
            return findK(nums,k,m+1,j);
        }else{
            return findK(nums,k,i,m-1);
        }
    }

    private int partition(int[] nums,int i,int j){
        int x=nums[i];
        int m=i;
        int n=i+1;
        while(n<=j){
            if(nums[n]<x){
                swap(nums,++m,n);
            }
            ++n;
        }
        swap(nums,i,m);
        return m;
    }

    private void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}
