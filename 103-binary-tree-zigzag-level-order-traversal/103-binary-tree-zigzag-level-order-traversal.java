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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> al = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        if(root==null){
            return al;
        }
        q.add(root);
        boolean reverse = false;
        while(!q.isEmpty()){
            int k = q.size();
            a = new ArrayList<>();
            while(k-->0){
                TreeNode curr = q.poll();
                a.add(curr.val);
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            if(reverse){
                Collections.reverse(a);
                al.add(a);
            }
            else{
                al.add(a);
            }
            reverse = !reverse;
        }
        return al;
    }
}