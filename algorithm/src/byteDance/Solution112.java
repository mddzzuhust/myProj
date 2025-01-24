package byteDance;

import commonDto.TreeNode;

public class Solution112 {
    public boolean hasPathSum_(TreeNode root, int sum) {
        if(root==null){
            return false;
        }else if(root!=null&&root.left==null&&root.right==null){
            if(sum==root.val)
                return true;
            else
                return false;
        }else{
            sum-=root.val;
            if(root.left!=null&&root.right==null)
                return hasPathSum_(root.left,sum);
            else if(root.left==null&&root.right!=null)
                return hasPathSum_(root.right,sum);
            else
                return hasPathSum_(root.left,sum)||hasPathSum_(root.right,sum);
        }
    }
    public boolean hasPathSum(TreeNode root,int sum){
        return hasPathSum_(root,sum);
    }
}
