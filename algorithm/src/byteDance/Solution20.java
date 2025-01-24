package byteDance;

import java.util.Stack;

public class Solution20 {
    public boolean isValid(String s) {
        Stack<Integer> stk=new Stack<Integer>();
        //int[] str=new int[]{'('-'A','['-'A','{'-'A'};
        if(s==null)  return false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{'){
                stk.push(s.charAt(i)-'A');
            }
            else if(stk.isEmpty()){
                return false;
            }
            else if(s.charAt(i)==')'&&(stk.pop()+'A'!='(')){
                return false;
            }
            else if(s.charAt(i)==']'&&(stk.pop()+'A'!='[')){
                return false;
            }
            else if(s.charAt(i)=='}'&&(stk.pop()+'A'!='{')){
                return false;
            }
        }
        if(stk.isEmpty())
            return true;
        else
            return false;
    }
}
