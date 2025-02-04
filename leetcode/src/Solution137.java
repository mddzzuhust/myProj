public class Solution137 {
    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            b = ~a & (b ^ num);
            a = ~b & (a ^ num);
        }
        return b;
    }
    public static void main(String[] args){
        Solution137 s=new Solution137();
        System.out.println(s.singleNumber(new int[]{2,2,3,2}));
    }
}
