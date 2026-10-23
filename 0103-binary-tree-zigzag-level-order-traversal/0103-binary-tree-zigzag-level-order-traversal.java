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
    class pair{
        int lev;
        TreeNode node;
        pair(TreeNode node,int lev){
            this.lev=lev;
            this.node=node;
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<pair> q = new LinkedList<>();
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> a=new ArrayList<>();
        if(root==null) return ans;
        int curlev=0;
        q.add(new pair(root,0));
        while(q.size()>0){
            pair n=q.remove();
            if(n.lev!=curlev){
                curlev++;
                if(n.lev%2==0){
                    Collections.reverse(a);
                    ans.add(a);
                }
                else{
                    ans.add(a);
                }
                a = new ArrayList<>();
            }
            a.add(n.node.val);
            if(n.node.left!=null)q.add(new pair(n.node.left,n.lev+1));
            if(n.node.right!=null)q.add(new pair(n.node.right,n.lev+1));
        }
                if(ans.size()%2!=0){
                    Collections.reverse(a);
                    ans.add(a);
                }
                else{
                    ans.add(a);
                }
        return ans;
    }
}