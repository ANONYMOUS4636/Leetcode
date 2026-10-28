/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> arr1=new ArrayList<>();
        ArrayList<TreeNode> arr2=new ArrayList<>();

        helper(arr1,root,p);
        helper(arr2,root,q);
        TreeNode ans = null;
int i = 0;

while (i < arr1.size() && i < arr2.size()
        && arr1.get(i) == arr2.get(i)) {
    ans = arr1.get(i);
    i++;
}

return ans;
        }
    public boolean helper(ArrayList<TreeNode> arr,TreeNode root,TreeNode p){
        if(root==null) return false;
        arr.add(root);
        if(root.val==p.val) return true;
        boolean a=helper(arr,root.left,p);
        boolean b=helper(arr,root.right,p);
        if(a || b) return true;
        arr.remove(arr.size() - 1);
        return false;
    }
}
