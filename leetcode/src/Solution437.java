package leetcode;

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
public class Solution437 {
    public int pathSum(TreeNode root, int sum) {
        if(root==null){
            return 0;
        }
        int result = CountPath(root,sum);
        int a = pathSum(root.left,sum);
        int b = pathSum(root.right,sum);

        return (result+a+b);
    }

    int CountPath(TreeNode root, int sum){
        if(root==null){
            return 0;
        }
        int result = 0;
        sum = sum-root.val;
        if(sum==0){
            result = 1;
        }
        return result + CountPath(root.left,sum)+CountPath(root.right,sum);
    }

}
