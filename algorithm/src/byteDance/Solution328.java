package byteDance;

import commonDto.ListNode;

public class Solution328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return head;
        ListNode h1 = new ListNode(0), r1 = h1;
        ListNode h2 = new ListNode(0), r2 = h2;
        h1.next = null;
        h2.next = null;
        ListNode p = head;
        while (p != null) {
            r1.next = p;
            r1 = r1.next;
            p = p.next;
            if (p != null) {
                r2.next = p;
                r2 = r2.next;
                p = p.next;
            }
        }
        r2.next = null;
        r1.next = h2.next;
        return h1.next;
    }
}
