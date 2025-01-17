package list.cycle;

/*
给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
分析：a：环外长度；b:相遇时，走了环内的长度，c:环的总长度-b
fast指针走的距离:a+n(b+c)+b=a+(n+1)b+nc
fast指针是slow指针的两倍:
a+(n+1)b+nc=2(a+b)⟹ a=c+(n−1)(b+c)
所以：
从相遇点到入环点的距离加上 n−1 圈的环长，恰好等于从链表头部到入环点的距离

因此，当发现 slow 与 fast 相遇时，我们使用一个指针head。起始，它指向链表头部；
随后，它和 slow 每次向后移动一个位置。最终，它们会在入环点相遇
 */
public class DetectCycle {

    public CycleNode detectCycle(CycleNode head) {
        CycleNode fast=head;
        CycleNode slow=head;
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
