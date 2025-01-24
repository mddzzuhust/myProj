package byteDance;

import commonDto.ListNode;

public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast=head;
        ListNode slow=head;
        for(int i=0;i<n&&fast!=null;i++){
            fast=fast.next;
        }
        if(fast!=null){
            while(fast.next!=null){
                fast=fast.next;
                slow=slow.next;
            }
            slow.next=slow.next.next;
            return head;
        }else{
            return head.next;
        }
    }
}
