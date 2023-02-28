class Solution {
    public int[] countBits(int nums) {
        int start = 0;
        int count = 2;

        int[] dp = new int[nums + 1];
        dp[0] = 0;
        if(nums > 0){
            dp[1] = 1;
        }

        int flag = 0;
        while(true){
            start = count;
            for(int i = start; i < count*2; i++){
                if(i <= nums){
                    dp[i] = 1 + dp[i - count];
                }
                else{
                    flag = 1;
                    break;
                }
            }
            if(flag == 1){
                break;
            }
            count *= 2;
        }
        return dp;
    }
}