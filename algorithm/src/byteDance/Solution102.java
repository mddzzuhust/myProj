package byteDance;

import commonDto.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        if(root==null)
            return list;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);
        while(queue.size()!=0){
            List<Integer> alist=new ArrayList<Integer>();
            for(TreeNode child:queue)
                alist.add(child.val);
            list.add(new ArrayList<Integer>(alist));
            Queue<TreeNode> queue2=queue;
            queue=new LinkedList<TreeNode>();
            for(TreeNode child:queue2){
                if(child.left!=null)
                    queue.add(child.left);
                if(child.right!=null)
                    queue.add(child.right);
            }
        }
        return list;
    }
}
