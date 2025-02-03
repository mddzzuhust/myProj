package classic150;

public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int end=m+n-1;
        int i=m-1,j=n-1;
        while(i>=0&&j>=0&&end>=0){
            if(nums1[i]>=nums2[j])
                nums1[end--]=nums1[i--];
            else
                nums1[end--]=nums2[j--];
        }
        while(i>=0)
            nums1[end--]=nums1[i--];
        while(j>=0)
            nums1[end--]=nums2[j--];
    }
    public static void main(String[] args){
        Solution88 s = new Solution88();
        int[] nums1=new int[]{1,2,4,5,6,0};
        int[] nums2=new int[3];
        String str="aaa";
        s.merge(nums1,5,nums2,1);
    }
}
