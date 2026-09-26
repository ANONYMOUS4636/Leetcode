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
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> st=new Stack<>();
        ListNode temp=head;
        while(temp!=null){
            if(st.isEmpty()) {
                st.push(temp);
                temp=temp.next;
                }
            else if(st.peek().val>=temp.val) {
                st.push(temp);
                temp=temp.next;
                }
            else if(st.peek().val<temp.val) {
                st.pop();
            }
        }
        while(st.size()!=0){
            temp=st.pop();
            if(st.isEmpty()) break;
            st.peek().next=temp;
        }
        head=temp;
        return head;
    }
}