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

        //APPROACH !:-
        // if(l.length==0) return null;
        // ListNode a=l[0];
        // for(int i=1;i<l.length;i++){
        //     ListNode merge=new ListNode(-1);
        //     ListNode m=merge;
        //     ListNode b=l[i];
        //     while(a!=null && b!=null){
        //     if(a.val>b.val){
        //         m.next=b;
        //         m=m.next;
        //         b=b.next;
        //     }
        //     else{
        //         m.next=a;
        //         m=m.next;
        //         a=a.next;
        //     }
        //     }
        //     while(a!=null){
        //         m.next=a;
        //         m=m.next;
        //         a=a.next;
        //     }
        //     while(b!=null){
        //         m.next=b;
        //         m=m.next;
        //         b=b.next;
        //     }
        //     a=merge.next;
        // }
        // return a;

        //APPROACH 2:-
        if(l.length==0) return null;
        int left=0;
        int right=l.length-1;
        return fun(left,right,l);
    }
    public ListNode fun(int left,int right,ListNode[] arr){
        if(left==right) return arr[left];
        int mid=(left+right)/2;
        ListNode a=fun(left,mid,arr);
        ListNode b=fun(mid+1,right,arr);
        ListNode merge=new ListNode(-1);
        ListNode m=merge;
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
            return merge.next;
    }

}