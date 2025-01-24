package byteDance;

public class Solution69 {
    public int mySqrt(int x) {
        long low=0;
        long high=x;
        long mid;
        while(low<=high){
            mid=(low+high)/2;
            //System.out.println(mid);
            long result=mid*mid;
            if(result==x)
                return (int)mid;
            else if(result>x)
                high=mid-1;
            else
                low=mid+1;
        }
        return (int)high;
    }
    public static void main(String[] args){
        Solution69 s = new Solution69();
        //int[][] num=new int[][]{0,0,0,0,1,0,0,0,0};
        System.out.println(s.mySqrt(2147483647));
    }
}
