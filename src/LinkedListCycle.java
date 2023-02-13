import java.io.BufferedReader;
import java.io.InputStreamReader;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListCycle {
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

                str = br.readLine();
                int pos = Integer.parseInt(str);

                boolean answer = findACycle(nums, pos);
                System.out.println(answer);
            }

        } catch (Exception e) {
            System.out.println("Exception");
        }
    }

    private static boolean findACycle(int[] nums, int pos) {
        ListNode root = createALinkedList(nums, pos);

        // APPROACH 1 - 3 lines below
//        printLinkedList(root);
//        int numberOfElements = nums.length;
//        return checkForCycle(root, numberOfElements);

        // Approach 2 - Floyd Cycle detect algo
        ListNode slow = root;
        ListNode fast = root;

        int flag = 0;
        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                flag = 1;
                break;
            }
        }

        if(flag == 1){
            return true;
        }else{
            return false;
        }
    }

    private static boolean checkForCycle(ListNode root, int numberOfElements) {
        ListNode temp = root;
        ListNode last = root;
        for(int i = 0; i < numberOfElements - 1; i++){
            temp = temp.next;
        }

        last = temp;
        temp = temp.next;

        if(temp == null){
            return false;
        }

        while(last != temp){
            temp = temp.next;
        }
        if(last == temp){
            return true;
        }
        return false;
    }

    private static void printLinkedList(ListNode root) {
        ListNode temp = root;
        while(temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    private static ListNode createALinkedList(int[] nums, int pos) {
        if(nums.length == 0)
            return null;

        ListNode root = new ListNode(nums[0]);
        ListNode temp = root;
        ListNode anotherTemp = root;

        for(int i = 0; i < nums.length - 1; i++){
            temp.next = new ListNode(nums[i + 1]);
            temp = temp.next;
        }

//        if(pos == 0){
//            temp.next = anotherTemp;
//            anotherTemp = anotherTemp.next;
//        }

        // create a cycle
        for(int i = 0; i < nums.length; i++){
            if(pos == i){
                temp.next = anotherTemp;
            }
            anotherTemp = anotherTemp.next;

        }

        return root;

    }
}
