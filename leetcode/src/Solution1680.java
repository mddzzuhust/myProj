

public class Solution1680 {
    public int concatenatedBinary(int n) {
        if (n == 1)
            return 1;
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= n; i++) {
            sb.append(Integer.toBinaryString(i));
        }
        int result = 0;
        int factor = 1;
        for (int i = sb.length()-1; i >= 0; i--) {
            result = result + factor * (sb.charAt(i) - '0');
            factor = (factor * 2)%1000000007;
            result = result % 1000000007;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution1680 s = new Solution1680();
        System.out.println(s.concatenatedBinary(12));
    }
}
