package byteDance;

import commonDto.ListNode;

public class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode first=new ListNode(0);
        ListNode last=first;

        ListNode p=head;
        while(head!=null){
            while(head.next!=null){
                if(p.val==head.next.val){
                    head=head.next;
                }else{
                    break;
                }
            }
            if(p==head){
                last.next=p;
                last=last.next;
            }
            p=head=head.next;
            last.next=null;
        }
        return first.next;
    }
}
