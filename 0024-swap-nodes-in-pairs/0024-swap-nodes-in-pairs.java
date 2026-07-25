/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode odd=new ListNode(-1);
        ListNode even=new ListNode(-1);
        ListNode o=odd;
        ListNode e=even;
        ListNode temp=head;
        int size=1;
        while(temp!=null){
            if(size%2!=0){
                o.next=temp;
                o=o.next;
                temp=temp.next;
                size++;
            }
            else{
                e.next=temp;
                e=e.next;
                temp=temp.next;
                size++;
            }
        }
        o.next=null;
        e.next=null;
        o=odd;
        e=even;
        e=e.next;
        o=o.next;
        size=1;
        ListNode result=new ListNode(-1);
        ListNode r=result;
        while(o!=null && e!=null){
            if(size%2==0){
                r.next=o;
                r=r.next;
                o=o.next;
                size++;
            }
            else{
                r.next=e;
                r=r.next;
                e=e.next;
                size++;
            }
        }
        while(o!=null){
            r.next=o;
            o=o.next;
            r=r.next;
        }
        while(e!=null){
            r.next=e;
            e=e.next;
            r=r.next;
        }
        r.next=null;
        return result.next;
    }
}