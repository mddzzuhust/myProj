package stack;

import java.util.Stack;

//最长有效括号:给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度
public class LongestValidParentheses {
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
        LongestValidParentheses s = new LongestValidParentheses();
        System.out.println(s.longestValidParentheses("()()"));
    }
}
