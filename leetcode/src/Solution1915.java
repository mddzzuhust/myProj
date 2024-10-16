public class Solution1915 {
    public long wonderfulSubstrings(String word) {
        long ans = 0;
        int mask = 0;
        long[] freq = new long[1<<10];
        freq[0] = 1;
        for(char c : word.toCharArray()){
            int index = c-'a';
            mask ^= (1<<index);
            ans += freq[mask];
            for (int i = 0; i < 10; i++) {
                ans += freq[mask ^ (1<<i)];
            }
            freq[mask]++;
        }
        return ans;
    }
}
