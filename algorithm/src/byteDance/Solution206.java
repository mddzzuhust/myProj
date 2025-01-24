package byteDance;

import commonDto.ListNode;

import java.util.Stack;

public class Solution206 {
    public ListNode reverseList(ListNode head) {
        if(head==null)
            return null;
        Stack<ListNode> stack=new Stack<ListNode>();
        ListNode temp=head;
        while(temp!=null){
            stack.push(temp);
            temp=temp.next;
        }
        head=stack.pop();
        temp=head;
        while(!stack.isEmpty()){
            temp.next=stack.pop();
            temp=temp.next;
        }
        temp.next=null;
        return head;
    }
}
