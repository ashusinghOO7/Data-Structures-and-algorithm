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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next ==null){
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evnt = even;
        boolean add=false;
        ListNode temp = head.next.next;
        ListNode res = odd;
        odd.next=null;
        even.next=null;
        while(temp!=null){
            if(add==true){
                even.next = temp;
                temp=temp.next;
                even = even.next;
                even.next=null;
            }
            else{
                odd.next = temp;
                temp=temp.next;
                odd = odd.next;
                odd.next=null;
            }
            add = !add;
        }
        odd.next = evnt;
        return head;
    }
}