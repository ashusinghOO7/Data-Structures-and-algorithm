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
    int ans = 0;
    int arr[] = new int[10];
    public int pseudoPalindromicPaths (TreeNode root) {
        helper(root);
        return ans;
    }
    void helper(TreeNode root){
        if(root==null){
            return;
        }
        arr[root.val]++;
        if(root.left==null && root.right==null){
            int count=0;
            for(int i=0;i<10;i++){
                count+=(arr[i]%2);
            }
            if(count==0 || count==1){
                ans++;
            }
        }
        helper(root.left);
        helper(root.right);
        arr[root.val]--;
    }
}