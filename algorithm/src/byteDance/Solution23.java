package byteDance;

import commonDto.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> heap =new PriorityQueue<ListNode>(new
        Comparator<ListNode>(){
            @Override public int compare(ListNode l1,ListNode l2){
                return l1.val-l2.val;
            }
        });

        ListNode dummy =new ListNode(0),cur=dummy,tmp;
        for(ListNode list:lists){
            if(list !=null){
                heap.offer(list);
            }
        }
        while(!heap.isEmpty()){
            tmp=heap.poll();
            cur.next=tmp;
            cur=cur.next;
            if(tmp.next!=null){
                heap.offer(tmp.next);
            }
        }
        return dummy.next;
    }
}
