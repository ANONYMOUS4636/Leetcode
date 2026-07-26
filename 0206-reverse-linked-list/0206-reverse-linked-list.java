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
    public ListNode reverseList(ListNode head) {
        //METHOD 1:-

        // ArrayList<ListNode> arr=new ArrayList<>();
        // ListNode temp=head;
        // while(temp!=null){
        //     arr.add(temp);
        //     temp=temp.next;
        // }
        // int n=arr.size();
        // for(int i=n-1;i>=1;i--){
        //     arr.get(i).next=arr.get(i-1);
        // }
        // if(n==0) return null;
        // arr.get(0).next=null;
        // return arr.get(n-1);

        //METHOD 2:-

        // ListNode p=null;
        // ListNode f=null;
        // ListNode c=head;
        // while(c!=null){
        //     f=c.next;
        //     c.next=p;
        //     p=c;
        //     c=f;
        // }
        // return p;

        //METHOD 3:-

        if(head==null) return null;
        if(head.next==null) return head;
        ListNode h=head;
        ListNode a=h.next;
        h.next=null;
        ListNode b=reverseList(a);
        a.next=h;
        return b;
    }
}