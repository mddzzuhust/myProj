package byteDance;

public class Solution42 {
    public int trap(int[] A) {
        int maxi=0,peak=0,sum=0;
        for(int i=0;i<A.length;i++){
            if(A[maxi]<A[i]){
                maxi=i;
            }
        }
        for(int i=0;i<maxi;i++){
            if(A[i]>peak)
                peak=A[i];
            else
                sum+=peak-A[i];
        }
        peak=0;
        for(int i=A.length-1;i>maxi;--i){
            if(A[i]>peak)
                peak=A[i];
            else
                sum+=peak-A[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution42 s=new Solution42();
        int[] A=new int[]{4,2,0,3,2,5};
        System.out.println(s.trap(A));
    }
}
