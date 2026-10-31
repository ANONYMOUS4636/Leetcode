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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> arr=new ArrayList<>();
        List<Integer> ele=new ArrayList<>();
        helper(root,arr,ele,targetSum);
        return arr;
    }
    public void helper(TreeNode root,List<List<Integer>> arr,List<Integer> ele,int targetSum) {
        if(root==null) return;
        targetSum-=root.val;
        ele.add(root.val);
        if(targetSum==0 && root.right==null && root.left==null){
            arr.add(new ArrayList<>(ele));
            ele.remove(ele.size()-1);
            return;
        }
        helper(root.left,arr,ele,targetSum);
        helper(root.right,arr,ele,targetSum);
        ele.remove(ele.size()-1);
    }
}