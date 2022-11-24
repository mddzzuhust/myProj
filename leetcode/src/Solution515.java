

import java.util.ArrayList;
import java.util.List;

public class Solution515 {
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
    public List<Integer> largestValues(TreeNode root) {
         List<Integer> ret = new ArrayList<>();

        if(null == root){
            return ret;
        }

         ret.add(root.val);
         List<TreeNode> tmp = new ArrayList<>();
         if(null != root.left){
             tmp.add(root.left);
         }
         if(null != root.right){
             tmp.add(root.right);
         }
         while (!tmp.isEmpty()){
             int max = tmp.get(0).val;
             List<TreeNode> middle = new ArrayList<>();
             for(TreeNode node : tmp){
                 max = Math.max(max, node.val);
                 if(null != node.left){
                     middle.add(node.left);
                 }
                 if(null != node.right){
                     middle.add(node.right);
                 }
             }
             ret.add(max);
             tmp = middle;
         }

         return ret;
    }
}
