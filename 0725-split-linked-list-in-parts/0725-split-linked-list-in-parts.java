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

 //If there are N nodes in the list, and k parts, then every part has N/k elements, except the first N%k parts have an extra one.

class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] arr=new ListNode[k];
        ListNode temp=head;
        int size=0;
        while(temp!=null){
            temp=temp.next;
            size++;
        }
        int ele=(int)Math.ceil(size/k);
        int rem=0;
        temp=head;
        int remi=size%k;
        for(int i=0;i<k;i++){
            ListNode head2=head;
            if(remi>0) rem=ele+1; else rem=ele;
            for(int j=0;j<rem-1;j++){
                if(temp==null){
                    break;
                }
                temp=temp.next;
            }
            if(temp==null){
                arr[i]=null;
            }
            else{
                head=temp.next;
                temp.next=null;
                arr[i]=head2;
                temp=head;
            }
            if(remi>0) remi--;
        }
        return arr;
    }
}