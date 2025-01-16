package string;
/*
通配符匹配:
给你一个输入字符串 (s) 和一个字符模式 (p) ，请你实现一个支持 '?' 和 '*' 匹配规则的通配符匹配：
'?' 可以匹配任何单个字符。
'*' 可以匹配任意字符序列（包括空字符序列）。
判定匹配成功的充要条件是：字符模式必须能够 完全匹配 输入字符串（而不是部分匹配）。
 */
public class WildcardMatch {
    public boolean isMatch(String s, String p) {
        p=prepare(p);
        int pi=0;
        int lastStar=-1;
        int lastMatch=0;
        for(int si=0;si<s.length();){
            if(pi<p.length()&&(p.charAt(pi)=='?'||s.charAt(si)==p.charAt(pi))){
                pi++;si++;
            }else if(pi<p.length()&&p.charAt(pi)=='*'){
                lastStar=pi;
                pi++;
                lastMatch=si;
            }else if(lastStar!=-1){
                pi=lastStar+1;
                lastMatch++;
                si=lastMatch;
            }else{
                return false;
            }
        }
        if(pi==p.length()||pi==p.length()-1&&p.charAt(pi)=='*')
            return true;
        return false;
    }
    public String prepare(String str){
        StringBuilder sb=new StringBuilder(str);
        for(int i=1;i<sb.length();){
            if(sb.charAt(i)=='*'&&sb.charAt(i)==sb.charAt(i-1))
                sb.deleteCharAt(i);
            else
                i++;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        WildcardMatch s=new WildcardMatch();
        System.out.println(s.isMatch("aa","aa"));
    }
}
