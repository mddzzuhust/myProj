package byteDance;

import java.util.Stack;

public class Solution32 {
    public int longestValidParentheses(String s) {
        if(s==null)  return 0;
        int len=s.length();
        int i=0;
        int ret=0;
        Stack<Integer> stk=new Stack<Integer>();
        while(i<len){
            if(s.charAt(i)=='(')
                stk.push(i);
            else{
                if(!stk.isEmpty()&&(s.charAt(stk.peek())=='(')){
                    stk.pop();
                    ret=Math.max(stk.isEmpty()?i+1:i-stk.peek(), ret);
                }
                else
                    stk.push(i);
            }
            i++;
        }
        return ret;
    }
    public static void main(String[] args){
        Solution32 s = new Solution32();
        int[] nums=new int[]{1,2};
        System.out.println(s.longestValidParentheses("()()"));
    }
}
