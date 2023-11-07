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
    // ITERATIVE METHOD
//     public ListNode reverseList(ListNode head) {
//         if(head == null){
//             return null;
//         }
//         if(head.next == null){
//             return head;
//         }
//         ListNode temp = head;
//         ListNode nextNode = temp.next;
//         temp.next = null;
//         ListNode nextNextNode = nextNode.next;

//         while(nextNextNode != null){
//             nextNode.next = temp;
//             temp = nextNode;

//             nextNode = nextNextNode;
//             nextNextNode = nextNextNode.next;
//         }

//         nextNode.next = temp;
//         temp = nextNode;

//         return temp;
//     }
    
    // RECURSION TYPE 1
    public ListNode reverseList(ListNode head){
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode cur = head;
        ListNode nextN = cur.next;
        cur.next = null;
        
        return reverse_ll(cur, nextN, nextN.next);
    }
    // utility function
    public ListNode reverse_ll(ListNode cur, ListNode nextN, ListNode nextNN){
        if(nextN == null){
            return cur;
        }
        
        nextNN = nextN.next;
        nextN.next = cur;
        cur = nextN;
        nextN = nextNN;
        return reverse_ll(cur, nextN, nextNN);
    }
}