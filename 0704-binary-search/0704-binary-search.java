class Solution {
    public int search(int[] nums, int target) {
        return binarySearchUtil(nums, target, 0, nums.length);
    }
    
    private int binarySearchUtil(int[] arr, int target, int start, int end) {

        if(start >= end){
            return -1;
        }

        int middle = (int)((start + end) / 2);

        if(target == arr[middle]){
            return middle;
        }
        else if(target < arr[middle]){
            return binarySearchUtil(arr, target, start, middle);
        }
        else if(target > arr[middle]){
            return binarySearchUtil(arr, target, middle + 1, end);
        }

        return -1;

    }
}