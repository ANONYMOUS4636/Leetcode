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
    public int level(TreeNode root) {
        if(root==null) return 0;
        return 1+Math.max(level(root.left),level(root.right));
    }
    public List<Integer> rightSideView(TreeNode root) {
        int x=level(root);
        List<Integer> arr=new ArrayList<>();
        helper(root,arr,0);
        return arr;


    }
    public void helper(TreeNode root,List<Integer> arr,int lev){
        if(root==null) return;
        if(lev==arr.size()) arr.add(root.val);
        helper(root.right,arr,lev+1);
        helper(root.left,arr,lev+1);
    }
}