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
    int cursum=0;
    public TreeNode convertBST(TreeNode root) {
        if(root==null) return null;
        root.right=convertBST(root.right);
        root.val+=cursum;
        cursum=root.val;
        root.left=convertBST(root.left);
        return root;
    }
}