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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //ListNode head1=reverse(l1);
        //ListNode head2=reverse(l2);
        ListNode h1=l1;
        ListNode h2=l2;
        ListNode head3=new ListNode(-1);
        ListNode h3=head3;
        int carry=0;
        int sum=0;
        while(h1!=null&&h2!=null){
            sum=h1.val+h2.val;
            h1=h1.next;
            h2=h2.next;
            if(carry!=0){
                sum+=carry;
            }
            if(sum>9){
                carry=sum/10;
                sum%=10;
            }
            else carry=0;
            ListNode n=new ListNode(sum);
            h3.next=n;
            h3=h3.next;
            sum=0;
        }
        sum=0;
        while(h2!=null){
            sum+=h2.val;
            h2=h2.next;
            if(carry!=0){
                sum+=carry;
            }
            if(sum>9){
                carry=sum/10;
                sum%=10;
            }
            else carry=0;
            ListNode n=new ListNode(sum);
            h3.next=n;
            h3=h3.next;
            sum=0;
        }
        while(h1!=null){
            sum+=h1.val;
            h1=h1.next;
            if(carry!=0){
                sum+=carry;
            }
            if(sum>9){
                carry=sum/10;
                sum%=10;
            }
            else carry=0;
            ListNode n=new ListNode(sum);
            h3.next=n;
            h3=h3.next;
            sum=0;
        }
        //sum=0;
        if(carry!=0){
            ListNode n=new ListNode(carry);
            h3.next=n;
            h3=h3.next;

        }
        return head3.next;
    }
    // public ListNode reverse(ListNode head){
    //     ListNode c=head;
    //     ListNode p=null;
    //     ListNode f=null;
    //     while(c!=null){
    //         f=c.next;
    //         c.next=p;
    //         p=c;
    //         c=f;
    //     }
    //     return p;
    // }
}