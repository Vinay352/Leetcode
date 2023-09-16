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
    public ListNode middleNode(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode slowPointer = head;
        ListNode fastPointer = head.next;

        if(fastPointer == null){
            return slowPointer;
        }

        while(slowPointer != null && fastPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        if(fastPointer == null){
            return slowPointer;
        }
        else if(fastPointer.next == null){
            return slowPointer.next;
        }
        return null;
    }
}