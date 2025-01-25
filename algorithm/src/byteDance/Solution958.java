package byteDance;

import commonDto.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution958 {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean leaf = false;
        while(!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if(poll.left == null && poll.right != null){
                return false;
            }
            if(leaf && (poll.left != null || poll.right != null)){
                return false;
            }
            if(poll.left != null){
                queue.offer(poll.left);
            }
            if(poll.right != null){
                queue.offer(poll.right);
            }
            if(poll.left == null || poll.right == null){
                leaf = true;
            }
        }
        return true;
    }
}
