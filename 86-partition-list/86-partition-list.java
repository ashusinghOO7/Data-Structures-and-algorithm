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
    public ListNode partition(ListNode head, int x) {
        ListNode res = new ListNode(0);
        ListNode less = res;
        ListNode MA = new ListNode(0);
        ListNode more = MA;
        while(head!=null){
            if(head.val<x){
                less.next = head;
                less = less.next;
            }
            else{
                more.next = head;
                more = more.next;
            }
            head=head.next;
        }
        less.next = MA.next;
        if(more.next!=null){
            more.next=null;
        }
        return res.next;
    }
}