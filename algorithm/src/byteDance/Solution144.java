package byteDance;

import commonDto.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret=new ArrayList<Integer>();
        Stack<TreeNode> stack=new Stack<TreeNode>();

        while(root!=null||stack.isEmpty()!=true){
            if(root!=null){
                ret.add(root.val);
                stack.push(root);
                root=root.left;
            }else{
                root=stack.pop();
                root=root.right;
            }
        }
        return ret;
    }
}
