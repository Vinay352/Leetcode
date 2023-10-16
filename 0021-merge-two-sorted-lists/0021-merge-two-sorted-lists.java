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
    public ListNode mergeTwoLists(ListNode c1, ListNode c2) {
        ListNode finalNode = new ListNode(-1);

        if(c1 == null && c2 == null){
            return null;
        }

        ListNode finalTemp = finalNode;

        while(c1 != null && c2 != null){
            if(c1.val > c2. val){
                finalTemp.next = c2;
                finalTemp = finalTemp.next;
                c2 = c2.next;
            }
            else if(c1.val < c2. val){
                finalTemp.next = c1;
                finalTemp = finalTemp.next;
                c1 = c1.next;
            }
            else if(c1.val == c2. val){
                finalTemp.next = c1;
                finalTemp = finalTemp.next;
                c1 = c1.next;

                finalTemp.next = c2;
                finalTemp = finalTemp.next;
                c2 = c2.next;
            }
        }

        while(c1 != null){
            finalTemp.next = c1;
            finalTemp = finalTemp.next;
            c1 = c1.next;
        }

        while(c2 != null){
            finalTemp.next = c2;
            finalTemp = finalTemp.next;
            c2 = c2.next;
        }

        return finalNode.next;
    }
}