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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] arr=new int[2];
        arr[0]=-1;
        arr[1]=-1;
        ListNode temp=head;
        int fircir=0,size=2;
        if(temp.next==null || temp.next.next==null)return arr;
        while(temp.next.next!=null){
            if(temp.next.val>temp.next.next.val && temp.next.val>temp.val){
                fircir=size;
                break;
            }
            else if(temp.next.val<temp.next.next.val && temp.next.val<temp.val){
                fircir=size;
                break;
            }
            size++;
            temp=temp.next;
        }
        temp=head;
        size=2;
        int ans=Integer.MAX_VALUE;
        int lastcir=0;
        int pre=fircir;
        while(temp.next.next!=null){
            if(temp.next.val>temp.next.next.val && temp.next.val>temp.val){
                lastcir=size;
                if(fircir!=lastcir && lastcir-pre<ans) ans=lastcir-pre;
                pre=size;
                
            }
            else if(temp.next.val<temp.next.next.val && temp.next.val<temp.val){
                lastcir=size;
                if(fircir!=lastcir && lastcir-pre<ans) ans=lastcir-pre;
                pre=size;
                
            }
            
            size++;
            temp=temp.next;
        }
        //if(fircir!=0 && lastcir!=0 && lastcir==fircir) arr[1]=lastcir;
        if(fircir!=0 && lastcir!=0 && lastcir!=fircir) arr[1]=lastcir-fircir;
         System.out.print(fircir);
         System.out.print(lastcir);
        if(ans!=Integer.MAX_VALUE) arr[0]=ans;
        return arr;
    }
}