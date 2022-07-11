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
    int maxLevel=0;
    public List<Integer> solver(TreeNode root,List<Integer> al, int level) {
        if(root==null){
            return al;
        }
        if(level>maxLevel){
            al.add(root.val);
            maxLevel = level;
        }
        solver(root.right,al,level+1);
        return solver(root.left,al,level+1);
        
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> al = new ArrayList<>();
        return solver(root,al,1);
    }
}