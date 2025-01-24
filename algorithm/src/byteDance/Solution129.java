package byteDance;

import commonDto.TreeNode;

public class Solution129 {
    int sum=0;
    public int sumNumbers(TreeNode root) {
        Helper(root,0);
        return sum;
    }
    void Helper(TreeNode root,int partSum){
        if(root==null)
            return;
        else if(root.left==null&&root.right==null){
            sum+=(10*partSum+root.val);
        }else{
            Helper(root.left,10*partSum+root.val);
            Helper(root.right,10*partSum+root.val);
        }
    }
}
