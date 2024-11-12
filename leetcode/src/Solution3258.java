public class Solution3258 {
    public int countKConstraintSubstrings(String s, int k) {
        int n = s.length(), res = 0;
        for (int i = 0; i < n; i++) {
            int[] count = new int[2];
            for (int j = i; j < n; j++) {
                count[s.charAt(j)-'0']++;
                if(count[0]>k && count[1]>k){
                    break;
                }
                res++;
            }
        }
        return res;
    }
}
