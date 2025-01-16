package list;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next; // 临时节点，用于保存下一个节点的引用
            curr.next = prev; // 将当前节点指向它的前一个节点
            prev = curr; // prev向后移动一个节点
            curr = nextTemp; // curr向后移动一个节点
        }

        return prev; // 返回反转后链表的头节点
    }

    public static void main(String[] args) {
        // 示例：创建链表 1 -> 2 -> 3 -> 4
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ReverseLinkedList solution = new ReverseLinkedList();
        ListNode reversedHead = solution.reverseList(head);

        // 输出反转后的链表：4 -> 3 -> 2 -> 1
        while (reversedHead != null) {
            System.out.print(reversedHead.val + " -> ");
            reversedHead = reversedHead.next;
        }
        System.out.println("null");
    }
}
