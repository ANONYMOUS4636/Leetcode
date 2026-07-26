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
    public void reorderList(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode head2=slow.next;
        slow.next=null;
        ListNode c=head2;
        slow=null;
        fast=null;
        while(c!=null){
            fast=c.next;
            c.next=slow;
            slow=c;
            c=fast;
        }
        c=head;
        int size=1;
        ListNode result=new ListNode(-1);
        ListNode r=result;
        while(c!=null && slow!=null){
            if(size%2!=0){
                r.next=c;
                r=r.next;
                c=c.next;
                size++;
            }
            else{
                r.next=slow;
                r=r.next;
                slow=slow.next;
                size++;
            }
        }
        while(c!=null){
            r.next=c;
            r=r.next;
            c=c.next;
        }
        while(slow!=null){
            r.next=slow;
            r=r.next;
            slow=slow.next;
        }
        head=result.next;
    }
}