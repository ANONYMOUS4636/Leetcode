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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int plo=0;
        int ilo=0;
        int phi=preorder.length-1;
        int ihi=inorder.length-1;
        return helper(preorder,inorder,plo,phi,ilo,ihi);
    }
    public TreeNode helper(int[] preorder, int[] inorder, int plo, int phi, int ilo, int ihi){
        if(plo > phi || ilo > ihi) return null;
        int r=-1;
        for(int i=0;i<=ihi;i++) if(preorder[plo]==inorder[i]) r=i;
        int cnt=r-ilo;
        TreeNode left=helper(preorder,inorder,plo+1,plo+cnt,ilo,r-1);
        TreeNode right=helper(preorder,inorder,plo+cnt+1,phi,r+1,ihi);
        TreeNode root=new TreeNode(preorder[plo]);
        root.right=right;
        root.left=left;
        return root;
    }
}