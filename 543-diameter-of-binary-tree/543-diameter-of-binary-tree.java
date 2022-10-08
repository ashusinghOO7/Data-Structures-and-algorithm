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
    /*
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        return 1+Math.max(height(root.left),height(root.right));
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        
        int ldiam = diameterOfBinaryTree(root.left);
        int rdiam = diameterOfBinaryTree(root.right);
        
        return Math.max(lh+rh,Math.max(ldiam,rdiam));
    }
    */
    private int longestDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        longestPath(root);
        return longestDiameter;
    }
    

    public int longestPath(TreeNode node){
        if(node == null){
            return 0;
        }
        // System.out.println("Finding longest path of : " + node.val);
        int leftLength = longestPath(node.left);
        // System.out.println("Left length of " + node.val + " is " + leftLength);
        int rightLength = longestPath(node.right);
        // System.out.println("Right length of " + node.val + " is " + rightLength);

        longestDiameter = Math.max(longestDiameter, leftLength+rightLength);
        return Math.max(leftLength, rightLength)+1;
    }
}