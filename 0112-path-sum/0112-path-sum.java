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
    public boolean hasPathSum(TreeNode root, int tar) {
        if(root==null) return false;
        return path(root,tar);
    }
    public boolean path(TreeNode root, int tar) {
        if(root!=null) tar=tar-root.val;
        if(root==null){
            if(tar==0) return true;
            else return false;
        }
        if(root.left==null && root.right!=null) return path(root.right,tar);
        if(root.right==null && root.left!=null) return path(root.left,tar);
        return path(root.left,tar) || path(root.right,tar);
    }
}