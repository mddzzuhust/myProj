public class Test {
    public int[] productExceptSelf(int[] nums) {
        int[] res=new int[nums.length];
        res[res.length-1]=1;

        for(int i=nums.length-2;i>=0;i--){
            res[i]=res[i+1]*nums[i+1];
        }
        int left=1;
        for(int i=0;i<nums.length;i++){
            res[i]*=left;
            left*=nums[i];
        }
        return res;
    }
    public static void main(String[] args) {
        Test test=new Test();
        test.productExceptSelf(new int[]{1,2,3,4});
    }
}
