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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode lastUnique = head;
        ListNode current = head.next;

        int proceed = 1;

        while(current != null){
            while(current.val == lastUnique.val){
                current = current.next;
                if(current == null){
                    lastUnique.next = current;
                    proceed = 0;
                    break;
                }
            }
            if(proceed == 1){
                lastUnique.next = current;
                lastUnique = current;
                current = lastUnique.next;
            }

        }
        return head;
    }
}