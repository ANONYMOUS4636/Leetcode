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
        return helper(preorder,inorder,0);
    }
    public TreeNode helper(int[] preorder, int[] inorder,int prepos) {
        if(prepos>=preorder.length) return null;
        int inpos=0;
        //int flag=0;
        for(int i=0;i<inorder.length;i++) if(preorder[prepos]==inorder[i]) inpos=i;//flag=1;}}
        //if(flag==0) return null;
        int[] inorder1=new int[inpos];
        int[] inorder2=new int[inorder.length-inpos-1];
        int[] preorder1=new int[inpos];
        int[] preorder2=new int[inorder.length-inpos-1];
        for(int i=0;i<inpos;i++) inorder1[i]=inorder[i];
        int t2=prepos+1;
        for(int i=0;i<inpos;i++) preorder1[i]=preorder[t2++];
        int t=inpos+1;
        for(int i=0;i<inorder2.length;i++) inorder2[i]=inorder[t++];
        for(int i=0;i<inorder2.length;i++) preorder2[i]=preorder[t2++];
        TreeNode root=new TreeNode(inorder[inpos]);
        TreeNode l1=helper(preorder1,inorder1,prepos);
        TreeNode r1=helper(preorder2,inorder2,prepos);
        //TreeNode l2=helper(preorder,inorder1,prepos+1);
        //TreeNode r2=helper(preorder,inorder2,prepos+1);
        // if(l1!=null) root.left=l1;
        // else if(l2!=null) root.left=l2;
        // if(r1!=null) root.right=r1;
        // else if(r2!=null) root.right=r2;
        // if(l1==null && l2==null && r1==null && r2==null) return root;
        root.left=l1;
        root.right=r1;
        return root;
    }
}