package byteDance;

import commonDto.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution105 {
    int[] ArrPreorder;
    int[] ArrInorder;
    Map<Integer,Integer> mapInorder=new
            HashMap<Integer,Integer>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0||preorder==null)
            return null;
        ArrPreorder=preorder;
        ArrInorder=inorder;
        for(int i=0;i<inorder.length;i++)
            mapInorder.put(inorder[i],i);
        int start=0,end=preorder.length-1;
        TreeNode root=new TreeNode(0);
        createTree(root,start,end,start,end);
        return root;
    }
    public void createTree(TreeNode root,int start1,int end1,int start2,int end2){
        int subStart1=start1,subStart2=start2,subEnd1=end1,subEnd2=end2;
        int target=ArrPreorder[start1];
        int indexInOrder=mapInorder.get(target);
        int len=indexInOrder-start2;
        int indexPreOrder=start1+len;
        if(start2<=indexInOrder-1){
            subStart1=start1+1;
            subEnd1=indexPreOrder;
            subEnd2=indexInOrder-1;
            root.left=new TreeNode(0);
            createTree(root.left,subStart1,start2,subStart2,subEnd2);
        }
        root.val=target;
        if(indexInOrder+1<=end2){
            subStart1=indexPreOrder+1;
            subStart2=indexInOrder+1;
            root.right=new TreeNode(0);
            createTree(root.right,subStart1,end1,subStart2,end2);
        }
    }
}
