package leetcode;

public class Solution1362 {
    public int[] closestDivisors(int num) {
        int N = num + 1;
        int gap = Integer.MAX_VALUE;
        int result1=0, result2=0;
        for (int i = 1; i * i <= N; i++) {
            if (N % i == 0) {
                int factor = N / i;
                if (Math.abs(factor - i) < gap) {
                    gap = Math.abs(factor - i);
                    result1 = i;
                    result2 = factor;
                }
            }
        }
        N = num + 2;
        for (int i = 1; i*i <= N; i++) {
            if(N%i==0){
                int factor = N/i;
                if (Math.abs(factor - i) < gap) {
                    gap = Math.abs(factor - i);
                    result1 = i;
                    result2 = factor;
                }
            }
        }
        int[] result = new int[2];
        result[0]=result1;
        result[1]=result2;
        return result;
    }

    public static void main(String[] args) {
        Solution1362 s = new Solution1362();
        int[] result = s.closestDivisors(2);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+" ");
        }
    }
}
