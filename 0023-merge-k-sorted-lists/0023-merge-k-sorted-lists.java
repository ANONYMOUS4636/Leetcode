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
    public ListNode mergeKLists(ListNode[] l) {
        if(l.length==0) return null;

        ListNode a=l[0];

        for(int i=1;i<l.length;i++){
            ListNode merge=new ListNode(-1);
            ListNode m=merge;
            ListNode b=l[i];
            while(a!=null && b!=null){
            if(a.val>b.val){
                m.next=b;
                m=m.next;
                b=b.next;
            }
            else{
                m.next=a;
                m=m.next;
                a=a.next;
            }
            }
            while(a!=null){
                m.next=a;
                m=m.next;
                a=a.next;
            }
            while(b!=null){
                m.next=b;
                m=m.next;
                b=b.next;
            }
            a=merge.next;
        }
        return a;
    }
}