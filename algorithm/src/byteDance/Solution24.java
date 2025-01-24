package byteDance;

import commonDto.ListNode;

public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if(head == null)
            return null;
        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode pre = helper;
        ListNode cur = head;
        while(cur!=null && cur.next!=null)
        {
            ListNode next = cur.next.next; //每次跳两个节点
            cur.next.next = cur;  //后一个接到前面
            pre.next = cur.next;  //此时helper和pre共享一个引用，则之前的后一个为helper的后继
            cur.next = next;
            pre = cur;
            cur = next;
        }
        return helper.next;
    }
}
