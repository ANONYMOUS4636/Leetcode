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
    public ListNode reverseBetween(ListNode head, int l, int right) {
        int size=1;

        //LEFT LL
        ListNode left=head;
        while(size<l-1){
            left=left.next;
            size++;
        }
        ListNode head2=head;
        if(l==1) left=null;
        else{
            head2=left.next;
            size=l;
            left.next=null;
        }

        //MIDDLE LL
        ListNode mid=head2;
        while(size<right){
            mid=mid.next;
            size++;
        }

        //END LL
        ListNode head3=mid.next;
        mid.next=null;


        //REVERSE MIDDLE LL
        ListNode p=null;
        ListNode f=null;
        ListNode c=head2;
        while(c!=null){
            f=c.next;
            c.next=p;
            p=c;
            c=f;
        }
        head2=p;
        mid=head2;

        while(mid.next!=null){
            mid=mid.next;
        }

        //MERGE
        mid.next=head3;
        if(left != null){
            left.next = head2;
            return head;
        }
        return head2;




    }
}