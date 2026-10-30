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
    public void flatten(TreeNode root) {
        helper(root);
    }
    public TreeNode helper(TreeNode root){
        if(root==null) return null;
        if(root.right==null && root.left==null) return root;
        TreeNode a=helper(root.left);
        TreeNode b=helper(root.right);
        TreeNode temp=a;
        if(a==null) return root;
        while(temp.right!=null){
            temp=temp.right;
        }
        temp.right=b;
        root.right=a;
        root.left=null;
        return root;
    }
}