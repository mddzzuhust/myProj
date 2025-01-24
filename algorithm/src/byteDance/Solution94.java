package byteDance;

import commonDto.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list =new ArrayList<Integer>();
        if(root==null){
            return list;
        }
        Stack<TreeNode> st=new Stack<TreeNode>();
        st.push(root);
        TreeNode top=null;
        while(!st.empty()){
            top=st.peek();
            while(top.left!=null){
                st.push(top.left);
                top=top.left;
            }
            while(top.right==null){
                list.add(top.val);
                st.pop();
                if(!st.empty())
                    top=st.peek();
                else
                    break;
            }
            if(!st.empty()){
                list.add(top.val);
                st.pop();
                st.push(top.right);
            }
        }
        return list;
    }
}
