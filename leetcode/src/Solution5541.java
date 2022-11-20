package leetcode;

public class Solution5541 {
    public int countSubstrings(String s, String t) {
        int[][] same = new int[100][100];
        int[][] diff = new int[100][100];
        int s_size = s.length();
        int t_size = t.length();
        for (int j = 0; j < t_size; j++) {
            same[0][j] = s.charAt(0)==t.charAt(j)?1:0;
            diff[0][j] = s.charAt(0)!=t.charAt(j)?1:0;
        }
        for (int i = 0; i < s_size; i++) {
            same[i][0] = s.charAt(i)==t.charAt(0)?1:0;
            diff[i][0] = s.charAt(i)!=t.charAt(0)?1:0;
        }
        for (int i = 1; i < s_size; i++) {
            for (int j = 0; j < t_size; j++) {
                if(s.charAt(i)==t.charAt(j)){
                    same[i][j] = same[i-1][j-1]+1;
                }
            }
        }
        for (int i = 0; i < s_size; i++) {
            for (int j = 0; j < t_size; j++) {
                if(s.charAt(i)==t.charAt(j)){
                    diff[i][j] = diff[i-1][j-1];
                }else {
                    diff[i][j] = same[i-1][j-1]+1;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < s_size; i++) {
            for (int j = 0; j < t_size; j++) {
                ans += diff[i][j];
            }
        }
        return ans;
    }
}
