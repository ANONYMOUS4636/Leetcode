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
    public int[][] spiralMatrix(int rows, int cols, ListNode head) {
        ListNode temp=head;
        int[][] mat=new int[rows][cols];
    for (int i = 0; i < rows; i++) {
    for (int j = 0; j < cols; j++) {
        mat[i][j] = -1;
    }
    }
    int firrow=0;
    int lastrow=rows-1;
    int fircol=0;
    int lastcol=cols-1;
    while(lastrow>=firrow && lastcol>=fircol && temp!=null){
        for(int i=fircol;i<=lastcol;i++){
            mat[firrow][i]=temp.val;
            temp=temp.next;
            if(temp==null) return mat;
        }
        firrow++;
        for(int i=firrow;i<=lastrow;i++){
            mat[i][lastcol]=temp.val;
            temp=temp.next;
            if(temp==null) return mat;
        }
        lastcol--;
        for(int i=lastcol;i>=fircol;i--){
            mat[lastrow][i]=temp.val;
            temp=temp.next;
            if(temp==null) return mat;
        }
        lastrow--;
        for(int i=lastrow;i>=firrow;i--){
            mat[i][fircol]=temp.val;
            temp=temp.next;
            if(temp==null) return mat;
        }
        fircol++;

    }
    return mat;
    
}}