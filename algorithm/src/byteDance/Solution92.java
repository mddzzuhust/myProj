package byteDance;

import commonDto.ListNode;

public class Solution92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null)
            return null;
        ListNode q=null;
        ListNode p=head;
        for(int i=0;i<m-1;i++){
            q=p;
            p=p.next;
        }
        ListNode end=p;
        ListNode pPre=p;
        p=p.next;
        for(int i=m+1;i<=n;i++){
            ListNode pNext=p.next;
            p.next=pPre;
            pPre=p;
            p=pNext;
        }
        end.next=p;
        if(q!=null)
            q.next=pPre;
        else head=pPre;
        return head;
    }
}
