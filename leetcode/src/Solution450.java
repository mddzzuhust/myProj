

public class Solution450 {

    public class TreeNode {
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

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode cur = root, curParent = null;

        while (cur != null && cur.val != key){
            curParent = cur;
            if(cur.val > key){
                cur = cur.left;
            }else {
                cur = cur.right;
            }
        }

        if(cur == null){
            return root;
        }

        if(cur.left == null && cur.right == null){
            cur = null;
        }else if(cur.left == null){
            cur = cur.right;
        }else if(cur.right == null){
            cur = cur.left;
        }else {
            TreeNode succeesor = cur.right, succesorParent = cur;
            while (succeesor.left != null){
                succesorParent = succeesor;
                succeesor = succeesor.left;
            }

            if(succesorParent.val == cur.val){
                succesorParent.right = succeesor.right;
            }else {
                succesorParent.left = succeesor.right;
            }
            succeesor.right = cur.right;
            succeesor.left = cur.left;
            cur = succeesor;
        }

        if(curParent == null){
            return cur;
        }else {
            if(curParent.left != null && curParent.left.val == key){
                curParent.left = cur;
            }else {
                curParent.right = cur;
            }
            return root;
        }
    }
}
