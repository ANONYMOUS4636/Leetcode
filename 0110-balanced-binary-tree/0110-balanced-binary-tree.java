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
    static boolean flag;
    public int level(TreeNode root) {
        if(root==null) return 0;
        int right=level(root.right);
        int left=level(root.left);
        if(Math.abs(left-right)>1) flag=false;
        return 1+Math.max(right,left);
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        flag=true;
        level(root);
        return flag;
    }
}