package byteDance;

public class Solution151 {
    public String reverseWords(String s) {
        int start=0;
        int end=s.length()-1;
        while(start<=s.length()-1&&s.charAt(start)==' '){
            start++;
        }
        while(end>=0&&s.charAt(end)==' '){
            end--;
        }
        if(start>end) return "";
        StringBuffer result=new StringBuffer();
        while(start<=end){
            StringBuffer word=new StringBuffer();
            while(end>=start&&s.charAt(end)!=' '){
                word.append(s.charAt(end));
                end--;
            }
            word.reverse();
            if(!word.equals("")){
                result.append(word+" ");
            }
            while(end>=start&&s.charAt(end)==' ')
                end--;
        }
        return result.substring(0,result.length()-1).toString();
    }
}
