/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int curSum;
    class triplet{
        boolean isBST;
        int max;
        int min;
        int sum;
        triplet(int max,int min,boolean isBST,int sum){
            this.max=max;
            this.min=min;
            this.isBST=isBST;
            this.sum=sum;
        }
    }
    public int maxSumBST(TreeNode root) {
        curSum=0;
        check(root);
        return curSum;
    }
        public triplet check(TreeNode root){
        if(root==null) return new triplet(Integer.MIN_VALUE,Integer.MAX_VALUE,true,0);
        triplet left=check(root.left);
        triplet right=check(root.right);
        int max=Math.max(root.val,Math.max(left.max,right.max));
        int min=Math.min(root.val,Math.min(left.min,right.min));
        boolean isBST=(left.isBST && right.isBST && root.val>left.max && root.val<right.min);
        int sum=left.sum+root.val+right.sum;
        if(isBST){
            curSum=Math.max(Math.max(root.val+left.sum+right.sum,curSum),Math.max(left.sum,right.sum));
        }
        return new triplet(max,min,isBST,sum);
    }
}