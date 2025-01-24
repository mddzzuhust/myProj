package byteDance;

import commonDto.TreeNode;

public class Solution110 {
    public boolean isBalanced(TreeNode root){
        if(root==null) return true;
        int height=getHeight(root);
        if(height==-1) return false;
        return true;
    }
    private int getHeight(TreeNode root){
        if(root==null) return 0;
        int leftHeight=getHeight(root.left);
        if(leftHeight==-1) return -1;
        int rightHeight=getHeight(root.right);
        if(rightHeight==-1) return -1;
        if(Math.abs(leftHeight-rightHeight)<=1)
            return Math.max(leftHeight,rightHeight)+1;
        return -1;
    }
}
