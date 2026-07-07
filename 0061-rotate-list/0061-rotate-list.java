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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode fast=head;
        ListNode slow=head;
        int size=0;
        if(head==null)return null;
        while(fast!=null){
            fast=fast.next;
            size++;
        }
        fast=head;
        if(k>size)k=k%size;
        if(k==0)return head;
        for(int i=1;i<=k;i++){
            fast=fast.next;
        }
        if(fast==null) return head;
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        ListNode h=slow.next;
        slow.next=null;
        fast.next=head;
        return h;
    }
}