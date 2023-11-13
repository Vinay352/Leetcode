class Solution {
    public void moveZeroes(int[] nums) {
        int totalZeroes = 0;
        int startPointer = 0;
        int nonZeroPointer = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[nonZeroPointer] == 0){
                totalZeroes++;
            }
            else if(nums[nonZeroPointer] != 0){
                nums[startPointer] = nums[nonZeroPointer];
                startPointer++;
            }
            nonZeroPointer++;
        }

        if(nonZeroPointer == nums.length){
            for(int i = startPointer; i < nums.length; i++){
                nums[i] = 0;
            }
        }
    }
}