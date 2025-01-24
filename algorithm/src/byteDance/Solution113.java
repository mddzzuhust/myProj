package byteDance;

import commonDto.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        ArrayList<Integer> temp=new ArrayList<Integer>();
        useme(root,sum,ans,temp);
        return ans;
    }
    public void useme(TreeNode root,int sum,List<List<Integer>>ans,ArrayList<Integer>temp){
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            if(root.val==sum){
                temp.add(root.val);
                ans.add(new ArrayList<Integer>(temp));
                temp.remove(temp.size()-1);
                return;
            }
        }
        temp.add(root.val);
        useme(root.left,sum-root.val,ans,temp);
        useme(root.right,sum-root.val,ans,temp);
        temp.remove(temp.size()-1);
    }
}
