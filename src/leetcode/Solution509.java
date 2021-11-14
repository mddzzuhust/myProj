package leetcode;

public class Solution509  {
    public int fib(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        int[] f = new int[1000];
        f[0] = 0; f[1] = 1;
        for(int index = 2; index <= n; index++){
            f[index] = f[index-1]+f[index-2];
        }
        return f[n];
    }

    public static void main(String[] args) {
        Solution509 s = new Solution509();
        System.out.println(s.fib(3));
    }
}
