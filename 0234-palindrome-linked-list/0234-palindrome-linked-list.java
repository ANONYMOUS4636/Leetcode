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
    public boolean isPalindrome(ListNode head) {
        //APPROACH 1:-

        // ArrayList<Integer> arr=new ArrayList<>();
        // ListNode temp=head;
        // while(temp!=null){
        //     arr.add(temp.val);
        //     temp=temp.next;
        // }
        // int i=0,j=arr.size()-1;
        // while(i<j){
        //     if(arr.get(i)!=arr.get(j)) return false;
        //     i++;
        //     j--;
        // }
        // return true;

        //APPROACH 2:-

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
        while(slow!=null && c!=null){
            if(slow.val!=c.val) return false;
            slow=slow.next;
            c=c.next;

        }
        return true;
    }
}