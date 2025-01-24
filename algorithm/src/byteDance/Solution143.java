package byteDance;

import commonDto.ListNode;

public class Solution143 {
    public void reorderList(ListNode head) {
        if(head==null||head.next==null)
            return;
        ListNode s=head;
        ListNode f=head;
        while(f!=null&&f.next!=null){
            s=s.next;
            f=f.next.next;
        }
        ListNode rh=s.next;
        s.next=null;
        ListNode revers=null;

        while(rh!=null){
            ListNode tp=new ListNode(rh.val);
            tp.next=revers;
            revers=tp;
            rh=rh.next;
        }
        s=head;

        while(revers!=null){
            rh=revers.next;
            revers.next=s.next;
            s.next=revers;
            s=revers.next;
            revers=rh;
        }
    }
}
