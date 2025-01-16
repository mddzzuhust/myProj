package dfs;

import list.ListNode;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode pre=null,slow=head,fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            pre=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        TreeNode tree=new TreeNode(slow.val);
        if(pre!=null){
            pre.next=null;
            tree.left=sortedListToBST(head);
        }else{
            tree.left=null;
        }
        tree.right=sortedListToBST(slow.next);
        return tree;
    }
}
