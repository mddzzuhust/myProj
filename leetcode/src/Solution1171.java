

import java.util.HashMap;
import java.util.Map;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { this.val = x; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution1171 {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int sum = 0;
        Map<Integer,ListNode> map = new HashMap<>();
        for (ListNode node = dummy; node.next!=null ; node=node.next) {
            sum = sum + node.val;
            map.put(sum, node);
        }
        sum = 0;
        for (ListNode node = dummy;node.next!=null;node=node.next){
            sum = sum + node.val;
            node.next = map.get(sum).next;
        }
        return dummy.next;
    }
}
