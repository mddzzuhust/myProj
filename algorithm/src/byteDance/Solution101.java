package byteDance;

import commonDto.TreeNode;

public class Solution101 {
    public boolean symmetric(TreeNode left, TreeNode right){
        if(left==null&&right==null) return true;
        if(left!=null&&right!=null&&left.val==right.val)
            return symmetric(left.right,right.left)&&
                    symmetric(left.left,right.right);
        else return false;
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return symmetric(root.left,root.right);
    }
}
