import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ContainsDuplicates {

    public static void main(String[] args) throws IOException {
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

                boolean answer = containsDuplicate(nums);
                System.out.println(answer);
            }

        } catch (Exception e) {
            System.out.println("Exception");
        }
    }

    public static boolean containsDuplicate(int[] nums) {

        boolean approach1 = n2Approach(nums);
//        System.out.println(approach1);

        boolean approach2 = sortAndCheckAdjacent(nums); // O(nlogn) + O(n)
//        System.out.println(approach2);

        boolean approach3 = sortandCheckViaModifiedBinary(nums); // O(nlogn) + O(logn)
//        System.out.println(approach3);

        return approach1 && approach2 && approach3;
    }

    private static boolean sortandCheckViaModifiedBinary(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
//        printArray(nums);
        return binarySearchModified(nums);
    }

    private static void printArray(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void mergeSort(int[] nums, int left, int right){
        if(left >= right)
            return ;

        int mid = left + (right - left)/2;

        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        mergeFunction(nums, left, right);
    }

    private static void mergeFunction(int[] nums, int left, int right) {

        int mid = left + (right - left)/2;

        int[] leftArr = new int[mid - left + 1];
        int[] rightArr = new int[right - mid];

        for(int i = 0; i < mid - left + 1; i++){
            leftArr[i] = nums[left + i];
        }
        for(int i = 0; i < right - mid; i++){
            rightArr[i] = nums[mid + 1 + i];
        }

        int i = 0, j = 0;
        int k = left;
        while(i < mid - left + 1 && j < right - mid){

            if(leftArr[i] <= rightArr[j]){
                nums[k] = leftArr[i];
                k++;
                i++;
            }
            else if(leftArr[i] > rightArr[j]){
                nums[k] = rightArr[j];
                k++;
                j++;
            }

        }

        while(i < mid - left + 1){
            nums[k] = leftArr[i];
            k++;
            i++;
        }

        while(j < right - mid){
            nums[k] = rightArr[j];
            k++;
            j++;
        }

    }

    public static boolean binarySearchModified(int[] nums){
        return _binarySearchModified(nums, 0, nums.length - 1, 0, nums.length - 1) ;
    }

    private static boolean _binarySearchModified(int[] nums, int left, int right, int min, int max) {

        boolean answer = false;
        if(right - left + 1 <= 2){
            if(left - 1 >= min){
                if(nums[left] == nums[left - 1]){
                    return true;
                }
            }
            if(left + 1 <= max){
                if(nums[left] == nums[left + 1]){
                    return true;
                }
            }
            if(right - 1 >= min){
                if(nums[right] == nums[right - 1]){
                    return true;
                }
            }
            if(right + 1 <= max){
                if(nums[right] == nums[right + 1]){
                    return true;
                }
            }
            return false;
        }

        int mid = left + (right - left)/2;
        if(nums[mid] == nums[mid - 1] || nums[mid] == nums[mid + 1]){
            return true;
        }

        boolean leftBool = _binarySearchModified(nums, left, mid, min, max);
        boolean rightBool = _binarySearchModified(nums, mid + 1, right, min, max);

        answer = leftBool || rightBool;
        return answer;
    }

    private static boolean sortAndCheckAdjacent(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);

        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == nums[i + 1]){
                return true;
            }
        }
        return false;
    }

    private static boolean n2Approach(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }
}
