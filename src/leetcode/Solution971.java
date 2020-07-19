package leetcode;

import sun.invoke.empty.Empty;

import java.util.ArrayList;
import java.util.List;

public class Solution971 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int index;
    List<Integer> flipped;
    int[] voyage;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        index=0;
        flipped = new ArrayList<>();
        this.voyage = voyage;
        dfs(root);
        if(!flipped.isEmpty()&&flipped.get(0)==-1){
            flipped.clear();
            flipped.add(-1);
        }
        return flipped;
    }
    private void dfs(TreeNode node){
        if(node!=null){
            if(node.val!=voyage[index++]){
                flipped.clear();
                flipped.add(-1);
                return;
            }
            if(index<voyage.length&&node.left!=null&&node.left.val!=voyage[index]){
                flipped.add(node.val);
                dfs(node.right);
                dfs(node.left);
            }else{
                dfs(node.left);
                dfs(node.right);
            }
        }
    }

}
