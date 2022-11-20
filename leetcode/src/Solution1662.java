package leetcode;

public class Solution1662 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuffer sb1 = new StringBuffer();
        for (String string : word1) {
            sb1.append(string);
        }
        StringBuffer sb2 = new StringBuffer();
        for (String string:word2){
            sb2.append(string);
        }
        if(sb1.toString().equals(sb2.toString())){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution1662 s = new Solution1662();
        String[] word1 = new String[]{"ab", "c"};
        String[] word2 = new String[]{"a", "bc"};
        System.out.println(s.arrayStringsAreEqual(word1,word2));
    }
}
