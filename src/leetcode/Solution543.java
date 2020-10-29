package leetcode;

public class Solution543 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root){
        if(root==null)
            return 0;
        int left = dfs(root.left),right = dfs(root.right);
        max = Math.max(left+right,max);
        return Math.max(left+1,right+1);
    }
}
