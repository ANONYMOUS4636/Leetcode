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
    static List<String> ans;
    public void helper(TreeNode root,List<String> ans,String s) {
        if(root==null) return;
        if(root.right==null && root.left==null){
            s=s+root.val;
            ans.add(s);
            return;
        }
        s=s+root.val+"->";
        helper(root.right,ans,s);
        helper(root.left,ans,s);

    }
    public List<String> binaryTreePaths(TreeNode root) {
        ans=new ArrayList<>();
        String s="";
        helper(root,ans,s);
        return ans;
    }
}