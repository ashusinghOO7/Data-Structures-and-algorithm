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
    public boolean chck(TreeNode root){
        if(root==null){
            return false;
        }
        if(root.val==1){
            return true;
        }
        return (chck(root.left) || chck(root.right));
    }
    public TreeNode pruneTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if(chck(root)==false){
            return null;
        }
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(chck(curr.left)==false){
                curr.left = null;
            }
            else{
                q.add(curr.left);
            }
            if(chck(curr.right)==false){
                curr.right = null;
            }
            else{
                q.add(curr.right);
            }
        }
        return root;
    }
}