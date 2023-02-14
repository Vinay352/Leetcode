import java.io.BufferedReader;
import java.io.InputStreamReader;

class ListNode2 {
    int val;
    ListNode2 next;
    ListNode2() {}
    ListNode2(int val) { this.val = val; }
    ListNode2(int val, ListNode2 next) { 
        this.val = val; 
        this.next = next; 
    }
}

public class MiddleOfTheLinkedList {
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

                ListNode2 answer = middleOfTheLinkedList(nums);
                System.out.println(answer.val);
            }

        } catch (Exception e) {
            System.out.println("Exception");
        }
    }

    private static ListNode2 middleOfTheLinkedList(int[] nums) {
        ListNode2 root = createALinkedList(nums);

        ListNode2 slow = root;
        ListNode2 fast = root;

        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
            if(fast.next != null){
                fast = fast.next;
            }
        }

        return slow;
    }

    private static void printLinkedList(ListNode root) {
        ListNode temp = root;
        while(temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    private static ListNode2 createALinkedList(int[] nums) {
        if(nums.length == 0)
            return null;

        ListNode2 root = new ListNode2(nums[0]);
        ListNode2 temp = root;

        for(int i = 0; i < nums.length - 1; i++){
            temp.next = new ListNode2(nums[i + 1]);
            temp = temp.next;
        }

        return root;

    }
}
