package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution966 {
    Set<String> words_perfect;
    Map<String, String> words_cap;
    Map<String, String> words_vow;

    public String[] spellchecker(String[] wordlist, String[] queries) {
        words_perfect = new HashSet<>();
        words_cap = new HashMap<>();
        words_vow = new HashMap<>();

        for (String word:wordlist) {
            words_perfect.add(word);

            String wordLow = word.toLowerCase();
            words_cap.putIfAbsent(wordLow,word);

            String wordDew = devowel(wordLow);
            words_vow.putIfAbsent(wordDew,word);
        }

        String[] ans = new String[queries.length];

        int index = 0;
        for (String query: queries) {
            ans[index++] = solve(query);
        }
        return ans;
    }

    private String solve(String word){
        if(words_perfect.contains(word))
            return word;
        String wordLow = word.toLowerCase();
        if(words_cap.containsKey(wordLow)){
            return words_cap.get(wordLow);
        }
        String wordVow = devowel(wordLow);
        if(words_vow.containsKey(wordVow)){
            return words_vow.get(wordVow);
        }
        return "";
    }

    private String devowel(String word){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if(isVowel(word.charAt(i))){
                result.append('*');
            }else {
                result.append(word.charAt(i));
            }
        }
        return result.toString();
    }

    private boolean isVowel(char c){
        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        String[] wordlist = new String[]{"KiTe","kite","hare","Hare"};
        String[] queries  = new String[]{"kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"};

        Solution966 s = new Solution966();
        String[] result = s.spellchecker(wordlist,queries);
        System.out.println(result);
    }
}
