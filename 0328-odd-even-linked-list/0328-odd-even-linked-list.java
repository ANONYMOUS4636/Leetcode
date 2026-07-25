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
    public ListNode oddEvenList(ListNode head) {
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
        o.next=even.next;
        return odd.next;
    }
}