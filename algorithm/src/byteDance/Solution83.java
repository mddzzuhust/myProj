package byteDance;

import commonDto.ListNode;

public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode first=head,last=first.next;
        while(last!=null){
            if(first.val==last.val){
                first.next=last.next;
                last=first.next;
            }else{
                first=last;
                last=last.next;
            }
        }
        return head;
    }
}
