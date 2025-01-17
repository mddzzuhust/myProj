package tree.bstree;
/*
给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。

有效 二叉搜索树定义如下：

节点的左子树只包含 小于 当前节点的数。
节点的右子树只包含 大于 当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        return isSubTreeLessThan(root.left,root.val)&&
                isSubTreeGreaterThan(root.right,root.val)&&
                isValidBST(root.left)&&isValidBST(root.right);
    }
    public boolean isSubTreeLessThan(TreeNode node,int val){
        if(node==null){
            return true;
        }
        return node.val<val&&
                isSubTreeLessThan(node.left,val)&&
                isSubTreeLessThan(node.right,val);
    }
    public boolean isSubTreeGreaterThan(TreeNode node,int val){
        if(node==null){
            return true;
        }
        return node.val>val&&
                isSubTreeGreaterThan(node.left,val)&&
                isSubTreeGreaterThan(node.right,val);
    }
    public static void main(String[] args) {
        IsValidBST s = new IsValidBST();
    }
}
