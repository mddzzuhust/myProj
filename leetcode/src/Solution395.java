

public class Solution395 {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        return dfs(s,0, n-1, k);
    }

    public int dfs(String s, int l, int r, int k) {
        int[] cnt = new int[26];
        for (int i = l; i <= r; i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        char split = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0 && cnt[i] < k) {
                split = (char) (i + 'a');
                break;
            }
        }

        if (split == 0) {
            return r - l + 1;
        }

        int i = l;
        int ret = 0;
        while (i <= r) {
            while (i <= r && s.charAt(i) == split) {
                i++;
            }
            if (i > r) {
                break;
            }
            int start = i;
            while (i <= r && s.charAt(i) != split){
                i++;
            }
            int length = dfs(s, start, i-1, k);
            ret = Math.max(ret, length);
        }
        return ret;
    }

    public int longestSubstring2(String s, int k){
        int ret = 0;
        int n = s.length();
        for(int t = 1; t <= 26 ; t++){
            int l = 0, r = 0;
            int[] cnt = new int[26];
            int total = 0;
            int less = 0;
            while (r<n){
                cnt[s.charAt(r)-'a']++;
                if(cnt[s.charAt(r)-'a']==1){
                    total++;
                    less++;
                }
                if(cnt[s.charAt(r)-'a']==k){
                    less--;
                }
                while (total>t){
                    cnt[s.charAt(l)-'a']--;
                    if(cnt[s.charAt(l)-'a']==k-1){
                        less++;
                    }
                    if(cnt[s.charAt(l)-'a']==0){
                        total--;
                        less--;
                    }
                    l++;
                }
                if(less == 0){
                    ret = Math.max(ret, r-l+1);
                }
                r++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution395 solution395 = new Solution395();
        String s = "aaabb";
        int k = 3;
        System.out.println(solution395.longestSubstring2(s, k));
    }
}
