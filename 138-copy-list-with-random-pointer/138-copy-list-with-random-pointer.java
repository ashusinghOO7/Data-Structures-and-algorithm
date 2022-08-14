/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        Node temp = head;
        Node next = temp;
        while(temp!=null){
            next = temp.next;
            temp.next = new Node(temp.val);
            temp.next.next = next;
            temp = next;
        }
        temp = head;
        while(temp!=null){
            if(temp.next!=null){
                temp.next.random = (temp.random!=null)?temp.random.next:null;
            }
            temp = temp.next.next;
        }
        Node orig = head;
        Node copy = head.next;
        Node res = copy;
        while(orig!=null){
            orig.next = orig.next.next;
            copy.next = (copy.next != null) ? copy.next.next  : copy.next;
            orig = orig.next;
            copy = copy.next;
        }
        return res;
    }
}