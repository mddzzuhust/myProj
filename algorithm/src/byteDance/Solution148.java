package byteDance;

import commonDto.ListNode;

public class Solution148 {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode head1=head;
        ListNode head2=getMid(head);
        head1=sortList(head1);
        head2=sortList(head2);
        return merge(head1,head2);
    }

    private ListNode merge(ListNode head1,ListNode head2){
        ListNode newhead=new ListNode(-1);
        ListNode newtail=newhead;
        while(head1!=null&&head2!=null){
            if(head1.val<=head2.val){
                newtail.next=head1;
                head1=head1.next;
            }else{
                newtail.next=head2;
                head2=head2.next;
            }
            newtail=newtail.next;
            newtail.next=null;
        }
        if(head1!=null)
            newtail.next=head1;
        if(head2!=null)
            newtail.next=head2;
        return newhead.next;
    }

    private ListNode getMid(ListNode head){
        ListNode fast=head.next;
        ListNode slow=head.next;
        ListNode prev=head;
        while(true){
            if(fast!=null)
                fast=fast.next;
            else
                break;
            if(fast!=null)
                fast=fast.next;
            else
                break;
            prev=slow;
            slow=slow.next;
        }
        prev.next=null;
        return slow;
    }
}
