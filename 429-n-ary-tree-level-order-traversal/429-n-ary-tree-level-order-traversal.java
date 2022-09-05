/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        List<List<Integer>> res= new ArrayList<>();
        if(root==null){
            return res;
        }
        while(!q.isEmpty()){
            int k = q.size();
            List<Integer> al = new ArrayList<>();
            while(k-->0){
                Node curr = q.poll();
                al.add(curr.val);
                for(Node i:curr.children){
                    q.add(i);
                }
            }
            res.add(al);
        }
        return res;
    }
}