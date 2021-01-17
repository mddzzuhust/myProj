package leetcode;

import Greedy.Solution;

public class Solution1721 {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode before = head;
        int count = 1;
        while (count < k) {
            before = before.next;
            count++;
        }
        ListNode current = before;

        ListNode after = head;
        while (before.next != null) {
            after = after.next;
            before = before.next;
        }
        int tmp = current.val;
        current.val = after.val;
        after.val = tmp;
        return head;
    }

    public static void main(String[] args) {
        Solution1721 s = new Solution1721();
        ListNode head = new ListNode(1);
        ListNode cur = head;
        cur.next = new ListNode(2);
        cur = cur.next;
        cur.next = new ListNode(3);
        cur = cur.next;
        cur.next = new ListNode(4);
        cur = cur.next;
        cur.next = new ListNode(5);
        cur = cur.next;
        cur = null;
        ListNode tmp = s.swapNodes(head,2);
    }
}
