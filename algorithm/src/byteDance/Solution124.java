package byteDance;

import commonDto.TreeNode;

public class Solution124 {
    static int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        max=Integer.MIN_VALUE;
        PathSum(root);
        return max;
    }
    public int PathSum(TreeNode root){
        if(root==null) return 0;
        int leftmaxsum=0;
        int rightmaxsum=0;
        int temp=root.val;
        if(root.left!=null){
            leftmaxsum=Math.max(PathSum(root.left),0);
        }
        if(root!=null){
            rightmaxsum=Math.max(PathSum(root.right),0);
        }
        temp=root.val+leftmaxsum+rightmaxsum;
        max=max>temp?max:temp;
        return Math.max(root.val,Math.max(root.val+leftmaxsum,root.val+rightmaxsum));
    }
}
