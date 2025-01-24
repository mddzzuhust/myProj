package byteDance;

import commonDto.TreeNode;

import java.util.Stack;

public class Solution230 {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack=new Stack<>();
        TreeNode n=root;

        while(n.left!=null){
            stack.push(n);
            n=n.left;
        }

        while(k>0&&(n!=null||!stack.isEmpty())){
            if(n==null){
                n=stack.pop();
                if(--k==0) return n.val;
                n=n.right;
            }else{
                stack.push(n);
                n=n.left;
            }
        }
        return n.val;
    }
}
