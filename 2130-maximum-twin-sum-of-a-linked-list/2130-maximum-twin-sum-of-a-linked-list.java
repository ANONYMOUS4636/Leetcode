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
    public int pairSum(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode head2=slow.next;
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
        int result = Integer.MIN_VALUE;
        while(slow!=null && c!=null){
            result=Math.max(result,(slow.val+c.val));
            slow=slow.next;
            c=c.next;
        }
        return result;
    }
}