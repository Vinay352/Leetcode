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
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        ListNode prev = head;
        ListNode current = prev.next;

        while( prev != null && prev.val == val ){
            prev = prev.next;
        }

        if(prev == null){
            return null;
        }

        current = prev.next;
        head = prev;

        while(current != null){
            if(current.val == val){
                prev.next = current.next;
            }
            else{
                prev = prev.next;
            }
            current = current.next;
        }
        return head;
    }
}