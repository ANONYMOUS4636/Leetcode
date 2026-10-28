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
        int[] arr=new int[x];
        helper(root,arr,0);
        List<Integer> ans=new ArrayList<>();
        for (int num : arr) {
            ans.add(num);
        }
        return ans;


    }
    public void helper(TreeNode root,int[] arr,int lev){
        if(root==null) return;
        arr[lev]=root.val;
        helper(root.left,arr,lev+1);
        helper(root.right,arr,lev+1);
    }
}