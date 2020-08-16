package leetcode;

import java.util.List;

public class Solution0206 {
    public boolean isPalindrome(ListNode head) {
        if(head==null)
            return true;
        if(head.next==null)
            return true;
        ListNode fast = head,slow =head;
        while (fast.next!=null&&fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode cur=slow.next;
        ListNode prev = null;
        while (cur!=null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        ListNode l1 = prev;
        ListNode l2 = head;
        while (l1!=null){
            if(l1.val!=l2.val)
                return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        one.next  = two;
        Solution0206 s = new Solution0206();
        System.out.println(s.isPalindrome(one));
    }
}
