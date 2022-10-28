package leetcode;

public class Solution783 {
    int pre;
    int ans;

    public int minDiffInBST(TreeNode root){
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root){
        if(null == root){
            return;
        }
        dfs(root.left);
        if(-1 == pre){
            pre = root.val;
        }else {
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
