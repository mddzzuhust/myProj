package byteDance;

import commonDto.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new ArrayList<Integer>();
        if(root==null)
            return list;
        list.add(root.val);
        if(root.right!=null)
            dfs(list,root.right,1);
        if(root.left!=null)
            dfs(list,root.left,1);
        return list;
    }

    static void dfs(List<Integer> list,TreeNode root,int height){
        if(height==list.size())
            list.add(root.val);
        if(root.right!=null)
            dfs(list,root.right,height+1);
        if(root.left!=null)
            dfs(list,root.left,height+1);
    }
}
