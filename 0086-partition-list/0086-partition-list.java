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
    public ListNode partition(ListNode head, int x) {
        ListNode small=new ListNode(-1);
        ListNode large=new ListNode(-1);
        ListNode sm=small;
        ListNode la=large;
        ListNode t=head;
        while(t!=null){
            if(t.val<x){
                sm.next=t;
                sm=sm.next;
                t=t.next;
            }
            else if(t.val>=x){
                la.next=t;
                la=la.next;
                t=t.next;
            }
        }
        sm.next=null;
        la.next=null;
        la=large;
        sm.next=la.next;
        return small.next;

    }
}