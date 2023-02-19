import java.io.BufferedReader;
import java.io.InputStreamReader;

class ListNode3 {
    int val;
    ListNode3 next;
    ListNode3() {}
    ListNode3(int val) { this.val = val; }
    ListNode3(int val, ListNode3 next) {
        this.val = val;
        this.next = next;
    }
}

public class ReverseLinkedList {

    public static void main(String[] args) {
        boolean flag = true;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while(flag){
                String str = br.readLine();
                if (str == "") {
                    flag = false;
//                    break;
                }
                String[] strArray = str.split(" ");
                int[] nums = new int[strArray.length];

                for (int i = 0; i < nums.length; i++) {
                    nums[i] = Integer.parseInt(strArray[i]);
                }

                ListNode3 linkedList = createALinkedList(nums);
                ListNode3 answer = reverseLinkedlistInPlace(linkedList);
//                    System.out.println(answer.val);

                printLinkedList(answer);
            }

        } catch (Exception e) {
            System.out.println("Exception");
        }
    }
    private static ListNode3 createALinkedList(int[] nums) {
        if(nums.length == 0)
            return null;

        ListNode3 root = new ListNode3(nums[0]);
        ListNode3 temp = root;

        for(int i = 0; i < nums.length - 1; i++){
            temp.next = new ListNode3(nums[i + 1]);
            temp = temp.next;
        }

        return root;
    }

    private static void printLinkedList(ListNode3 answer) {
        if(answer == null){
            return ;
        }

        ListNode3 head = answer;

        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    private static ListNode3 reverseLinkedlistInPlace(ListNode3 head) {
//        ListNode3 iterativeReverse = reverseIteratively(head);
//        return iterativeReverse;

        if(head == null){
            return null;
        }

        ListNode3 previous = head;
        ListNode3 current = head.next;
        ListNode3 next = current.next;
        previous.next = null;

        if(head.next == null){
            return head;
        }

        ListNode3 recursiveReverse = reverseRecursively(previous, current, next);
        return recursiveReverse;
    }

    private static ListNode3 reverseRecursively(ListNode3 previous, ListNode3 current, ListNode3 next) {
        if(next == null){
            current.next = previous;
            return current;
        }
        current.next = previous;
        ListNode3 temp = next.next;

        previous = current;
        current = next;

        next = temp;

        return reverseRecursively(previous, current, next);
    }

    private static ListNode3 reverseIteratively(ListNode3 head) {
        if(head == null){
            return null;
        }

        if(head.next == null){
            return head;
        }

        ListNode3 previous = head;
        ListNode3 current = head.next;
        ListNode3 next = current.next;
        previous.next = null;

        while(next != null){
            current.next = previous;
            ListNode3 temp = next.next;

            previous = current;
            current = next;

            next = temp;
        }

        current.next = previous;

        return current;
    }

}
