class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int n = nums.length;

        for(int i =0; i < n; i++){
            sum += nums[i];
        }

        int shouldBeSum = (int) Math.floor( (n * (n + 1)) / 2 );

        if(shouldBeSum != sum){
            return shouldBeSum - sum;
        }
        else{
            return 0;
        }
    }
}