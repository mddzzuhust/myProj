package list.cycle;

public class HasCycle {
    public boolean hasCycle(CycleNode head) {
        if (head == null) {
            return false;
        }

        CycleNode slow = head;
        CycleNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}
