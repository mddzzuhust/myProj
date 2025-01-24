package byteDance;

import commonDto.ListNode;

public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA,lenB;
        if(headA==null||headB==null) return null;
        lenA=0;lenB=0;
        ListNode lna=headA;
        while(lna!=null){
            lenA++;
            lna=lna.next;
        }
        ListNode lnb=headB;
        while(lnb!=null){
            lenB++;
            lnb=lnb.next;
        }
        lna=headA;
        lnb=headB;
        if(lenA>lenB){
            while(lenB<lenA){
                lna=lna.next;
                lenB++;
            }
        }else if(lenA<lenB){
            while(lenA<lenB){
                lnb=lnb.next;
                lenA++;
            }
        }
        while((lnb!=lna)&&(lnb!=null)&&(lna!=null)){
            lnb=lnb.next;lna=lna.next;
        }
        if(lnb!=null&&lna!=null){
            return lna;
        }else{
            return null;
        }
    }
}
