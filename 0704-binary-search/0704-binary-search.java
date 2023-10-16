class Solution {
    public int search(int[] nums, int target) {
        return binarySearchImplementaion(nums, target, 0, nums.length - 1);
    }
    
    private int binarySearchImplementaion(int[] nums, int target, int start, int end) {

        int middleIndex = start + (int) Math.floor((end - start) / 2);
        int middleValue = nums[middleIndex];

        if(middleValue == target){
            return middleIndex;
        }

        if(start == end){
            if(middleValue == target){
                return middleIndex;
            }
            else{
                return -1;
            }
        }

        if(start == end - 1){
            if(nums[start] == target){
                return start;
            }
            else if(nums[end] == target){
                return end;
            }
            else{
                return -1;
            }
        }

        if(middleValue < target){
            // search in right half
            return binarySearchImplementaion(nums, target, middleIndex + 1, end);
        }

        if(middleValue > target){
            // search in left half
            return binarySearchImplementaion(nums, target, start, middleIndex - 1);
        }

        return -1;

    }
}