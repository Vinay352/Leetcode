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
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }

        ListNode slowPointer = head;
        ListNode fastPointer = head.next;

        if(fastPointer == null){
            return true;
        }

        // find middle
        while(slowPointer != null && fastPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        if(fastPointer == null){ // odd length list
            // slowPointer is middle
            ListNode start = head;
            ListNode middle = slowPointer.next;

            String firstHalf = "";
            String secondHalf = "";

            while(middle != null && start != slowPointer){
                firstHalf += start.val;
                start = start.next;

                secondHalf += middle.val;
                middle = middle.next;
            }

            StringBuilder reverseSecondString = new StringBuilder();
            reverseSecondString.append(secondHalf);
            reverseSecondString.reverse();

            if(firstHalf.equals(reverseSecondString.toString())){
                return true;
            }else{
                return false;
            }
        }
        else if(fastPointer.next == null){ // even length list
            // slowPointer.next is middle
            ListNode start = head;
            ListNode middle = slowPointer.next;

            String firstHalf = "";
            String secondHalf = "";

            while(middle != null && start != slowPointer.next){
                firstHalf += start.val;
                start = start.next;

                secondHalf += middle.val;
                middle = middle.next;
            }

            StringBuilder reverseSecondString = new StringBuilder();
            reverseSecondString.append(secondHalf);
            reverseSecondString.reverse();

            if(firstHalf.equals(reverseSecondString.toString())){
                return true;
            }else{
                return false;
            }
        }
        return true;
    }
}