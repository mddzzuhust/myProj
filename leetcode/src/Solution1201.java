

public class Solution1201 {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long lcmAB=lcm(a,b);
        long lcmAC=lcm(a,c);
        long lcmBC=lcm(b,c);

        long lcm = lcm(lcmAB,c);

        long m = lcm/a+lcm/b+lcm/c-lcm/lcmAB-lcm/lcmAC-lcm/lcmBC+1;

        long epoch = n/m;
        long r=n%m;
        long result = epoch*lcm;

        if(r>0){
            long left = 1,right = lcm;
            while (left<right){
                long mid = left + (right-left)/2;
                long count = mid/a+mid/b+mid/c-mid/lcmAB-mid/lcmAC-mid/lcmBC+mid/lcm;
                if(count>=r){
                    right = mid;
                }else {
                    left = mid+1;
                }
            }
            result += left;
        }
        return (int)result;
    }

    private long lcm(long a,long b){
        return a*b/gcd(a,b);
    }

    private long gcd(long x,long y){
        if(x==0) return y;
        return gcd(y%x,x);
    }

    public static void main(String[] args) {
        Solution1201 solution1201 = new Solution1201();
        System.out.println(solution1201.nthUglyNumber(1000000000,2,217983653,336916467));
    }
}