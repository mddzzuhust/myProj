package leetcode;

public class Solution951 {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1==null&&root2!=null)
            return false;
        else if(root1!=null&&root2==null)
            return false;
        else if(root1==null&&root2==null)
            return true;
        if(root1.val!=root2.val)
            return false;
        boolean ll = flipEquiv(root1.left,root2.left);
        boolean lr = flipEquiv(root1.left,root2.right);
        boolean rl = flipEquiv(root1.right,root2.left);
        boolean rr = flipEquiv(root1.right,root2.right);

        return true&&((ll&&rr)||(lr&&rl));
    }
    public boolean flipEquiv1(TreeNode root1, TreeNode root2) {
        if(root1==null&&root2!=null)
            return false;
        else if(root1!=null&&root2==null)
            return false;
        else if(root1==null&&root2==null)
            return true;
        if(root1.val!=root2.val)
            return false;
        boolean ll = flipEquiv(root1.left,root2.left);
        boolean lr = flipEquiv(root1.left,root2.right);
        boolean rl = flipEquiv(root1.right,root2.left);
        boolean rr = flipEquiv(root1.right,root2.right);
        return true&&((ll&&rr)||(lr&&rl));
    }
}
