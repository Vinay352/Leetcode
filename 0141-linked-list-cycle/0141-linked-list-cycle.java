/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }

        ListNode slowPointer = head;
        ListNode fastPointer = head.next;

        if(fastPointer == null){
            return false;
        }
        if(fastPointer == slowPointer){
            return true;
        }

        while(slowPointer != null && fastPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if(slowPointer == fastPointer){
                return true;
            }
        }
        return false;
    }
}