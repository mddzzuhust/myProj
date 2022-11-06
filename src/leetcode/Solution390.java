package leetcode;

public class Solution390 {
    public int lastRemaining(int n) {
        int a1 = 1;
        int k=0,cnt=n,step=1;
        while (cnt > 1){
            if(k%2 == 0){
                a1 = a1 + step;
            }else {
                a1 = (cnt%2 == 0)? a1 : a1+step;
            }
            k++;
            cnt = cnt>>1;
            step = step<<1;
        }
        return a1;
    }

    public static void main(String[] args) {
        Solution390 solution390 = new Solution390();
        System.out.println(solution390.lastRemaining(9));
    }
}
