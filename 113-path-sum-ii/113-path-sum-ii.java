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
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> al = new ArrayList<>();
    public void helper (TreeNode root,int target,int curr, List<Integer> al){
        if(root==null){
            return;
        }
        al.add(root.val);
        if(root.left==null && root.right==null){
            if(curr+root.val==target)
                res.add(new ArrayList<>(al));
            return;
        }
        if(root.left!=null){
            helper(root.left,target,curr+root.val,al);
            al.remove(al.size()-1);
        }
        if(root.right!=null){
            helper(root.right,target,curr+root.val,al);;
            al.remove(al.size()-1);
        }
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res.clear();
        al.clear();
        helper(root,targetSum,0,al);
        return res;
    }
}