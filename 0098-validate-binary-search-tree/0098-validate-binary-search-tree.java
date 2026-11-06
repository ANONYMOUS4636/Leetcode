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
    TreeNode temp=null;
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        boolean c=true;
        boolean a=isValidBST(root.left);     
        if (temp != null && temp.val >= root.val) c=false;
        temp=root;
        boolean b=isValidBST(root.right);
        return a&&b&&c;
    }
}