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
    public ListNode removeNodes(ListNode head) {
        head=reverse(head);
        ListNode i=head.next;
        ListNode j=head;
        while(i!=null){
            if(i.val<j.val) i=i.next;
            else {
                j.next=i;
                j=i;
                i=i.next;
            }
        }
        j.next=null;
        return reverse(head);
    }
    public ListNode reverse(ListNode head){
        ListNode c=head;
        ListNode p=null;
        ListNode f=null;
        while(c!=null){
            f=c.next;
            c.next=p;
            p=c;
            c=f;
        }
        return p;
    }
}