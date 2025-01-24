package byteDance;

import commonDto.ListNode;

public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        do{
            if(fast!=null)
                fast=fast.next;
            else
                return null;
            if(fast!=null)
                fast=fast.next;
            else
                return null;
            slow=slow.next;
        }while(fast!=slow);
        fast=head;
        while(fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
}
