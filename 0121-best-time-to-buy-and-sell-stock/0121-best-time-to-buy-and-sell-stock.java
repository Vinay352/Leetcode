class Solution {
    public int maxProfit(int[] nums) {
        int leftBuyIndex = 0;
        int rightSellIndex = 1;

        if(nums.length == 1){
            return 0;
        }

        int maxProfit = 0;
        int currentProfit = 0;

        for(; leftBuyIndex < nums.length - 1 && rightSellIndex < nums.length;){

            currentProfit = computeProfit(rightSellIndex, leftBuyIndex, nums);

            if(nums[rightSellIndex] < nums[leftBuyIndex]){ // selling low and buying high
                leftBuyIndex=rightSellIndex;
            }

            if(currentProfit > maxProfit){
                maxProfit = currentProfit;
            }
            rightSellIndex++;


        }
        return maxProfit;
    }
    
    private int computeProfit(int rightSellIndex, int leftBuyIndex, int[] nums) {

        return (nums[rightSellIndex] - nums[leftBuyIndex]);

    }
}