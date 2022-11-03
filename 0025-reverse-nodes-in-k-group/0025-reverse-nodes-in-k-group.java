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
    
     
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int cnt = 0;
        while(curr!=null && cnt!=k){
            cnt++;
            curr=curr.next;
        }
        if(cnt==k){
            curr = reverseKGroup(curr,k);
            while(cnt-->0){
                ListNode tmp = head.next;
                head.next = curr;
                curr= head;
                head = tmp;
            }
            head =curr;
        }
        return head;
    }
}