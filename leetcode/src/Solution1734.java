

public class Solution1734 {
    public int[] decode(int[] encoded) {
        int base = 1, two = encoded[0];
        int n = encoded.length + 1;
        for (int i = 2; i <= n; i++) {
            base ^= i;
        }
        for (int i = 2; i < encoded.length - 1; i += 2) {
            two ^= encoded[i];
        }
        two ^= encoded[encoded.length - 1];
        two = two ^ base;
        int[] ans = new int[n];
        ans[n - 1] = two ^ encoded[encoded.length - 1];
        ans[n - 2] = two;
        for (int i = ans.length - 2; i > 0; i--) {
            ans[i - 1] = ans[i] ^ encoded[i - 1];
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution1734 s = new Solution1734();
        int[] encoded = new int[]{6,5,4,6};
        int[] ans = s.decode(encoded);
        for (int tmp : ans) {
            System.out.println(tmp);
        }
    }
}
