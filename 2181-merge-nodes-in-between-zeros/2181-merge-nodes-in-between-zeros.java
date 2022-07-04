/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeNodes(ListNode head) {
        
        ListNode res = new ListNode(0);
        ListNode temp = res;
        int curr=0;
        while(head!=null){
            if(head.val==0){
                if(curr!=0){
                    temp.next = new ListNode(curr);
                    temp=temp.next;
                    curr=0;
                }
            }
            else{
                curr+=head.val;
            }
            head=head.next;
        }
        return res.next;
    }
}