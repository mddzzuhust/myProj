package byteDance;

import commonDto.ListNode;

public class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur=head;
        int cnt=0;
        while(cur!=null&&cnt!=k){
            cur=cur.next;
            cnt++;
        }
        if(cnt==k){
            cur=reverseKGroup(cur,k);
            while(0<=--cnt){
                ListNode tmp=head.next;
                head.next=cur;
                cur=head;
                head=tmp;
            }
            head=cur;
        }
        return head;
    }
}
