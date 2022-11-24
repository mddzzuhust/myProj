
public class Offer26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B==null||A==null)
            return false;
        boolean res = false;
        if(A.val==B.val){
            res = isMatch(A,B);
        }
        if(!res){
            res = isSubStructure(A.left,B);
        }
        if(!res){
            res = isSubStructure(A.right,B);
        }
        return res;
    }

    private boolean isMatch(TreeNode a,TreeNode b){
        if(b==null)
            return true;
        if(a==null)
            return false;
        if(a.val!=b.val)
            return false;
        return isMatch(a.left,b.left)&&isMatch(a.right,b.right);
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
