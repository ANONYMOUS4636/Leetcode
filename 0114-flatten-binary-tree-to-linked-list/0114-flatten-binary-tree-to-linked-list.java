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
        if(root==null) return;
        ArrayList<TreeNode> arr=new ArrayList<>();
        helper(root,arr);
        TreeNode temp=arr.get(0);
        root.right=temp;
        root.left=null;
        for(int i=1;i<arr.size();i++){
            temp.right=arr.get(i);
            temp=temp.right;
            temp.left=null;
        }
        temp.right=null;
    }
    public void helper(TreeNode root,ArrayList<TreeNode> arr){
        if(root==null) return;
        arr.add(root);
        helper(root.left,arr);
        helper(root.right,arr);
    }
}