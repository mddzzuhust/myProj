package byteDance;

import commonDto.ListNode;

public class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l,head;
        ListNode tmp1=l1,tmp2=l2;
        if(l1==null&&l2==null)  return null;
        if(l1==null)  return l2;
        if(l2==null)  return l1;
        if(tmp1.val<tmp2.val){
            head=l=tmp1;tmp1=tmp1.next;
        }
        else{
            head=l=tmp2;tmp2=tmp2.next;
        }
        while(tmp1!=null&&tmp2!=null){
            if(tmp1.val<tmp2.val){
                l.next=tmp1;
                l=l.next;
                tmp1=tmp1.next;
            }
            else{
                l.next=tmp2;
                l=l.next;
                tmp2=tmp2.next;
            }
        }
        if(tmp1!=null){
            l.next=tmp1;
        }
        if(tmp2!=null){
            l.next=tmp2;
        }
        return head;
    }
}
