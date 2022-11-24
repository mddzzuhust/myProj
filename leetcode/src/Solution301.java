

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution301 {
    private Set<String> set = new HashSet<>();
    public List<String> removeInvalidParentheses(String s) {
        char[] ss = s.toCharArray();
        int open = 0, close = 0;
        for (char ch:ss){
            if(ch=='('){
                open++;
            }else if(ch==')'){
                if(open>0)
                    open--;
                else
                    close++;
            }
        }
        backTracking(ss,new StringBuilder(),0,0,0,open,close);
        return new ArrayList<>(set);
    }

    public void backTracking(char[] ss,StringBuilder sb,int index,int open,int close,int openRem,int closeRem){
        if(index==ss.length){
            if(openRem==0&&closeRem==0){
                set.add(sb.toString());
                return;
            }
        }
        if(ss[index]=='('&&openRem>0||ss[index]==')'&&closeRem>0){
            backTracking(ss, sb, index + 1, open, close, openRem - (ss[index] == '(' ? 1 : 0), closeRem - (ss[index] == ')' ? 1 : 0));
        }
        sb.append(ss[index]);
        if(ss[index]!='('&&ss[index]!=')'){
            backTracking(ss,sb,index+1,open,close,openRem,closeRem);
        }else if(ss[index]=='('){
            backTracking(ss,sb,index+1,open+1,close,openRem,closeRem);
        }else if(open>close){
            backTracking(ss,sb,index+1,open,close+1,openRem,closeRem);
        }
        sb.deleteCharAt(sb.length()-1);
    }

    public static void main(String[] args) {
        Solution301 s = new Solution301();
        System.out.println(s.removeInvalidParentheses(")("));
    }
}
