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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dum=new ListNode(-1);
        ListNode temp=dum;
        ListNode i=head;
        ListNode j=head;
        while(i!=null && i.next!=null){
            if(i.next!=null && i.val!=i.next.val){
                temp.next=i;
                temp=temp.next;
                i=i.next;
            }
            else if(i.next!=null && i.val==i.next.val){
                j=i.next;
                while(j!=null && j.val==i.val){
                    j=j.next;
                }
                i=j;
                temp.next=i;
            }
            // else {
            //     // This covers the case where 'i' is the last standalone node
            //     temp.next = i;
            //     temp = temp.next;
            //     i = i.next;
            // }
        }
        temp.next=i;
        return dum.next;
    }
}