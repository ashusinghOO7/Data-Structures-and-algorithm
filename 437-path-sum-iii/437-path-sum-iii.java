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
    HashMap<Long,Integer> hm = new HashMap<>();
    
    int res = 0;
    public void sum(TreeNode root,int TargetSum,long sum){
        if(root==null){
            return;
        }
        sum+=root.val;
        res+=hm.getOrDefault(sum-TargetSum,0);
        hm.put(sum,hm.getOrDefault(sum,0)+1);
        sum(root.left,TargetSum,sum);
        sum(root.right,TargetSum,sum);
        hm.put(sum,hm.get(sum)-1);
    }
    public int pathSum(TreeNode root, int targetSum) {
        hm.clear();
        hm.put(0l,1);
        res=0;
        sum(root,targetSum,0l);
        return res;
    }
}