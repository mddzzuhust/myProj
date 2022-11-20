package leetcode;

public class Solution424 {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        if(len<2){
            return len;
        }

        char[] charArray = s.toCharArray();
        int left = 0;
        int right = 0;

        int res = 0;
        int maxCount = 0;
        int[] freq = new int[26];
        while (right < len){
            freq[charArray[right]-'A']++;
            maxCount = Math.max(maxCount, freq[charArray[right] - 'A']);
            right++;

            if(right - left > maxCount + k){
                freq[charArray[left]-'A']--;
                left++;
            }

            res = Math.max(res, right - left);
        }

        return res;
    }
}
