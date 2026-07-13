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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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