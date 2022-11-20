package leetcode;

import java.util.Arrays;

public class Solution1657 {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length()!=word2.length()){
            return false;
        }
        char[] chars  = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        
        int[] help1 = new int[26];
        for (int i = 0; i < chars.length; i++) {
            help1[chars[i]-'a']++;
        }
        
        int[] help2 = new int[26];
        for (int i = 0; i < chars2.length; i++) {
            help2[chars2[i]-'a']++;
        }

        for (int i = 0; i < help1.length; i++) {
            if(help1[i]>0&&help2[i]==0){
                return false;
            }
            if(help1[i]==0&&help2[i]>0){
                return false;
            }
        }

        Arrays.sort(help1);
        Arrays.sort(help2);

        for (int i = 0; i < help1.length; i++) {
            if(help1[i]!=help2[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution1657 s = new Solution1657();
        String word1 = "cabbba";
        String word2 = "aabbss";
        System.out.println(s.closeStrings(word1,word2));
    }
}
