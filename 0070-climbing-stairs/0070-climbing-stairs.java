class Solution {
    public int climbStairs(int n) {
        // intialize the array for storing no. of way to climb n stairs
        int[] dpCountWaysToClimbStairs = new int[n + 1];
        
        // define the base cases
        dpCountWaysToClimbStairs[0] = 0; // 0 ways to climb 0 stairs
        dpCountWaysToClimbStairs[1] = 1; // 1 way to climb 1 stair
        
        if(n > 1){ // if we need to calculate for more than 1 stairs
            dpCountWaysToClimbStairs[2] = 2; // 2 ways to climb 2 stairs: (1+1), 2
        }
    
        // loop to calculate ways to climb for every stair until nth stair
        for(int i = 3; i <= n; i++){
            // to climb ith stair = ways to climb (i - 2)th stair + ways to climb (i - 1)th stair
            dpCountWaysToClimbStairs[i] = dpCountWaysToClimbStairs[i - 2] + dpCountWaysToClimbStairs[i - 1];
        }

        return dpCountWaysToClimbStairs[n]; // the final position is the answer
    }
}