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
    public ListNode sortList(ListNode head) {
        //BASE CASE
        if(head==null || head.next==null) return head;
        
        //SPLIT
        ListNode fast=head;
        ListNode slow=head;
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode head2=slow.next;
        slow.next=null;
        
        //RECURSION
        head2=sortList(head2);
        head=sortList(head); //we have to capture the head
        
        //MERGE
        return mergeTwoNode(head,head2);
    }
     public ListNode mergeTwoNode(ListNode list1,ListNode list2) {
        ListNode i=list1;
        ListNode j=list2;
        ListNode dum=new ListNode(-1);
        ListNode k=dum;
        while(i!=null && j!=null){
            if(j.val>i.val){
                k.next=i;
                k=k.next;
                i=i.next;
            }
            else{
                k.next=j;
                k=k.next;
                j=j.next;
            }
        }
        while(i!=null){
            k.next=i;
            k=k.next;
            i=i.next;
        }
        while(j!=null){
            k.next=j;
            k=k.next;
            j=j.next;
        }
        return dum.next;
    }
}