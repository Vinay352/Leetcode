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
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode temp = head;
        ListNode nextNode = temp.next;
        temp.next = null;
        ListNode nextNextNode = nextNode.next;

        while(nextNextNode != null){
            nextNode.next = temp;
            temp = nextNode;

            nextNode = nextNextNode;
            nextNextNode = nextNextNode.next;
        }

        nextNode.next = temp;
        temp = nextNode;

        return temp;
    }
}