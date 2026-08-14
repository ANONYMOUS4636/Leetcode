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
    public ListNode reverseKGroup(ListNode head, int k) {
        int cap=0;
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            cap++;
        }
        //System.out.println(cap);
        if(cap<k){
            return head;
        }
        int size=0;
        temp=head;
        while(size<k-1){
            temp=temp.next;
            size++;
        }
        //System.out.println(size);

        if(temp==null) return reverse(head);

        ListNode head2=temp.next;
        temp.next=null;
        head=reverse(head);
        head2=reverseKGroup(head2,k);
        temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }

        temp.next=head2;
        return head;
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